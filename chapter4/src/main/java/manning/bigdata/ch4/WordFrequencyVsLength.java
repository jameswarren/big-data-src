package manning.bigdata.ch4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordFrequencyVsLength {

	public static class SplitAndFilterMapper extends MapReduceBase
	 implements Mapper<LongWritable, Text, Text, IntWritable> {

		public static final Set<String> STOP_WORDS = new HashSet<String>() {{
			add("the");
			add("a");
		}};
			
		private static final IntWritable one = new IntWritable(1);
		private Text word = new Text();
	 
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				if (!STOP_WORDS.contains(token)) {
					word.set(token);
					output.collect(word, one);
				}
			}
		}
	}
	
	public static class LengthToCountReducer extends MapReduceBase implements
			Reducer<Text, IntWritable, IntWritable, IntWritable> {
		
		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<IntWritable, IntWritable> output, Reporter reporter)
				throws IOException {
			int sum = 0;
			while (values.hasNext()) {
				sum += values.next().get();
			}
			output.collect(new IntWritable(key.toString().length()), new IntWritable(
					sum));
		}
	}
	
	public static class PassThroughMapper extends MapReduceBase implements
			Mapper<IntWritable, IntWritable, IntWritable, IntWritable> {
		
		public void map(IntWritable key, IntWritable count,
				OutputCollector<IntWritable, IntWritable> output, Reporter reporter)
				throws IOException {
			output.collect(key, count);
		}
	}
	
	public static class AverageReducer extends MapReduceBase implements
			Reducer<IntWritable, IntWritable, IntWritable, DoubleWritable> {
		public void reduce(IntWritable key, Iterator<IntWritable> values,
				OutputCollector<IntWritable, DoubleWritable> output, Reporter reporter)
				throws IOException {
			int sum = 0;
			int count = 0;
			while (values.hasNext()) {
				sum += values.next().get();
				count += 1;
			}
			double avg = 1.0 * sum / count;
			output.collect(key, new DoubleWritable(avg));
		}
	}
	
	private static void runWordBucketer( // first job
			String input, String output) throws Exception {
		JobConf conf = new JobConf(WordFrequencyVsLength.class);
		conf.setJobName("freqVsAvg1");
		conf.setMapperClass(SplitAndFilterMapper.class);
		conf.setReducerClass(LengthToCountReducer.class);
		FileInputFormat.setInputPaths(conf, new Path(input));
		FileOutputFormat.setOutputPath(conf, new Path(output));
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		JobClient.runJob(conf);
	}

	private static void runBucketAverager(String input, String output)
			throws Exception { // second job
		JobConf conf = new JobConf(WordFrequencyVsLength.class);
		conf.setJobName("freqVsAvg2");
		conf.setMapperClass(PassThroughMapper.class);
		conf.setReducerClass(AverageReducer.class);
		FileInputFormat.setInputPaths(conf, new Path(input));
		FileOutputFormat.setOutputPath(conf, new Path(output));
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(DoubleWritable.class);
		JobClient.runJob(conf);
	}
	
	public static void main(String[] args) throws Exception {
		String tmpPath = "/tmp/" + UUID.randomUUID().toString();
		runWordBucketer(args[0], tmpPath);
		runBucketAverager(tmpPath, args[1]);
		FileSystem.get(new Configuration()).delete(new Path(tmpPath), true);
	}
	
}