<?php
/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
include_once $GLOBALS['THRIFT_ROOT'].'/Thrift.php';


$GLOBALS['E_GenderType'] = array(
  'MALE' => 1,
  'FEMALE' => 2,
);

final class GenderType {
  const MALE = 1;
  const FEMALE = 2;
  static public $__names = array(
    1 => 'MALE',
    2 => 'FEMALE',
  );
}

class PersonID {
  static $_TSPEC;

  public $cookie = null;
  public $user_id = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'cookie',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'user_id',
          'type' => TType::I64,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['cookie'])) {
        $this->cookie = $vals['cookie'];
      }
      if (isset($vals['user_id'])) {
        $this->user_id = $vals['user_id'];
      }
    }
  }

  public function getName() {
    return 'PersonID';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->cookie);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->user_id);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PersonID');
    if ($this->cookie !== null) {
      $xfer += $output->writeFieldBegin('cookie', TType::STRING, 1);
      $xfer += $output->writeString($this->cookie);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->user_id !== null) {
      $xfer += $output->writeFieldBegin('user_id', TType::I64, 2);
      $xfer += $output->writeI64($this->user_id);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PageID {
  static $_TSPEC;

  public $url = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'url',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['url'])) {
        $this->url = $vals['url'];
      }
    }
  }

  public function getName() {
    return 'PageID';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->url);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PageID');
    if ($this->url !== null) {
      $xfer += $output->writeFieldBegin('url', TType::STRING, 1);
      $xfer += $output->writeString($this->url);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class Location {
  static $_TSPEC;

  public $city = null;
  public $state = null;
  public $country = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'city',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'state',
          'type' => TType::STRING,
          ),
        3 => array(
          'var' => 'country',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['city'])) {
        $this->city = $vals['city'];
      }
      if (isset($vals['state'])) {
        $this->state = $vals['state'];
      }
      if (isset($vals['country'])) {
        $this->country = $vals['country'];
      }
    }
  }

  public function getName() {
    return 'Location';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->city);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->state);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->country);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('Location');
    if ($this->city !== null) {
      $xfer += $output->writeFieldBegin('city', TType::STRING, 1);
      $xfer += $output->writeString($this->city);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->state !== null) {
      $xfer += $output->writeFieldBegin('state', TType::STRING, 2);
      $xfer += $output->writeString($this->state);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->country !== null) {
      $xfer += $output->writeFieldBegin('country', TType::STRING, 3);
      $xfer += $output->writeString($this->country);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PersonPropertyValue {
  static $_TSPEC;

  public $full_name = null;
  public $gender = null;
  public $location = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'full_name',
          'type' => TType::STRING,
          ),
        2 => array(
          'var' => 'gender',
          'type' => TType::I32,
          ),
        3 => array(
          'var' => 'location',
          'type' => TType::STRUCT,
          'class' => 'Location',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['full_name'])) {
        $this->full_name = $vals['full_name'];
      }
      if (isset($vals['gender'])) {
        $this->gender = $vals['gender'];
      }
      if (isset($vals['location'])) {
        $this->location = $vals['location'];
      }
    }
  }

  public function getName() {
    return 'PersonPropertyValue';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->full_name);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->gender);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRUCT) {
            $this->location = new Location();
            $xfer += $this->location->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PersonPropertyValue');
    if ($this->full_name !== null) {
      $xfer += $output->writeFieldBegin('full_name', TType::STRING, 1);
      $xfer += $output->writeString($this->full_name);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->gender !== null) {
      $xfer += $output->writeFieldBegin('gender', TType::I32, 2);
      $xfer += $output->writeI32($this->gender);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->location !== null) {
      if (!is_object($this->location)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('location', TType::STRUCT, 3);
      $xfer += $this->location->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PersonProperty {
  static $_TSPEC;

  public $id = null;
  public $property = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'id',
          'type' => TType::STRUCT,
          'class' => 'PersonID',
          ),
        2 => array(
          'var' => 'property',
          'type' => TType::STRUCT,
          'class' => 'PersonPropertyValue',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['id'])) {
        $this->id = $vals['id'];
      }
      if (isset($vals['property'])) {
        $this->property = $vals['property'];
      }
    }
  }

  public function getName() {
    return 'PersonProperty';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->id = new PersonID();
            $xfer += $this->id->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->property = new PersonPropertyValue();
            $xfer += $this->property->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PersonProperty');
    if ($this->id !== null) {
      if (!is_object($this->id)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('id', TType::STRUCT, 1);
      $xfer += $this->id->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->property !== null) {
      if (!is_object($this->property)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('property', TType::STRUCT, 2);
      $xfer += $this->property->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PagePropertyValue {
  static $_TSPEC;

  public $page_views = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'page_views',
          'type' => TType::I32,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['page_views'])) {
        $this->page_views = $vals['page_views'];
      }
    }
  }

  public function getName() {
    return 'PagePropertyValue';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->page_views);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PagePropertyValue');
    if ($this->page_views !== null) {
      $xfer += $output->writeFieldBegin('page_views', TType::I32, 1);
      $xfer += $output->writeI32($this->page_views);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PageProperty {
  static $_TSPEC;

  public $id = null;
  public $property = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'id',
          'type' => TType::STRUCT,
          'class' => 'PageID',
          ),
        2 => array(
          'var' => 'property',
          'type' => TType::STRUCT,
          'class' => 'PagePropertyValue',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['id'])) {
        $this->id = $vals['id'];
      }
      if (isset($vals['property'])) {
        $this->property = $vals['property'];
      }
    }
  }

  public function getName() {
    return 'PageProperty';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->id = new PageID();
            $xfer += $this->id->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->property = new PagePropertyValue();
            $xfer += $this->property->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PageProperty');
    if ($this->id !== null) {
      if (!is_object($this->id)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('id', TType::STRUCT, 1);
      $xfer += $this->id->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->property !== null) {
      if (!is_object($this->property)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('property', TType::STRUCT, 2);
      $xfer += $this->property->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class EquivEdge {
  static $_TSPEC;

  public $id1 = null;
  public $id2 = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'id1',
          'type' => TType::STRUCT,
          'class' => 'PersonID',
          ),
        2 => array(
          'var' => 'id2',
          'type' => TType::STRUCT,
          'class' => 'PersonID',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['id1'])) {
        $this->id1 = $vals['id1'];
      }
      if (isset($vals['id2'])) {
        $this->id2 = $vals['id2'];
      }
    }
  }

  public function getName() {
    return 'EquivEdge';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->id1 = new PersonID();
            $xfer += $this->id1->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->id2 = new PersonID();
            $xfer += $this->id2->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('EquivEdge');
    if ($this->id1 !== null) {
      if (!is_object($this->id1)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('id1', TType::STRUCT, 1);
      $xfer += $this->id1->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->id2 !== null) {
      if (!is_object($this->id2)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('id2', TType::STRUCT, 2);
      $xfer += $this->id2->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class PageViewEdge {
  static $_TSPEC;

  public $person = null;
  public $page = null;
  public $nonce = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'person',
          'type' => TType::STRUCT,
          'class' => 'PersonID',
          ),
        2 => array(
          'var' => 'page',
          'type' => TType::STRUCT,
          'class' => 'PageID',
          ),
        3 => array(
          'var' => 'nonce',
          'type' => TType::I64,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['person'])) {
        $this->person = $vals['person'];
      }
      if (isset($vals['page'])) {
        $this->page = $vals['page'];
      }
      if (isset($vals['nonce'])) {
        $this->nonce = $vals['nonce'];
      }
    }
  }

  public function getName() {
    return 'PageViewEdge';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->person = new PersonID();
            $xfer += $this->person->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->page = new PageID();
            $xfer += $this->page->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->nonce);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('PageViewEdge');
    if ($this->person !== null) {
      if (!is_object($this->person)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('person', TType::STRUCT, 1);
      $xfer += $this->person->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->page !== null) {
      if (!is_object($this->page)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('page', TType::STRUCT, 2);
      $xfer += $this->page->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->nonce !== null) {
      $xfer += $output->writeFieldBegin('nonce', TType::I64, 3);
      $xfer += $output->writeI64($this->nonce);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class DataUnit {
  static $_TSPEC;

  public $person_property = null;
  public $page_property = null;
  public $equiv = null;
  public $page_view = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'person_property',
          'type' => TType::STRUCT,
          'class' => 'PersonProperty',
          ),
        2 => array(
          'var' => 'page_property',
          'type' => TType::STRUCT,
          'class' => 'PageProperty',
          ),
        3 => array(
          'var' => 'equiv',
          'type' => TType::STRUCT,
          'class' => 'EquivEdge',
          ),
        4 => array(
          'var' => 'page_view',
          'type' => TType::STRUCT,
          'class' => 'PageViewEdge',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['person_property'])) {
        $this->person_property = $vals['person_property'];
      }
      if (isset($vals['page_property'])) {
        $this->page_property = $vals['page_property'];
      }
      if (isset($vals['equiv'])) {
        $this->equiv = $vals['equiv'];
      }
      if (isset($vals['page_view'])) {
        $this->page_view = $vals['page_view'];
      }
    }
  }

  public function getName() {
    return 'DataUnit';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->person_property = new PersonProperty();
            $xfer += $this->person_property->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->page_property = new PageProperty();
            $xfer += $this->page_property->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 3:
          if ($ftype == TType::STRUCT) {
            $this->equiv = new EquivEdge();
            $xfer += $this->equiv->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 4:
          if ($ftype == TType::STRUCT) {
            $this->page_view = new PageViewEdge();
            $xfer += $this->page_view->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('DataUnit');
    if ($this->person_property !== null) {
      if (!is_object($this->person_property)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('person_property', TType::STRUCT, 1);
      $xfer += $this->person_property->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->page_property !== null) {
      if (!is_object($this->page_property)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('page_property', TType::STRUCT, 2);
      $xfer += $this->page_property->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->equiv !== null) {
      if (!is_object($this->equiv)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('equiv', TType::STRUCT, 3);
      $xfer += $this->equiv->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->page_view !== null) {
      if (!is_object($this->page_view)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('page_view', TType::STRUCT, 4);
      $xfer += $this->page_view->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class Pedigree {
  static $_TSPEC;

  public $true_as_of_secs = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'true_as_of_secs',
          'type' => TType::I32,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['true_as_of_secs'])) {
        $this->true_as_of_secs = $vals['true_as_of_secs'];
      }
    }
  }

  public function getName() {
    return 'Pedigree';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::I32) {
            $xfer += $input->readI32($this->true_as_of_secs);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('Pedigree');
    if ($this->true_as_of_secs !== null) {
      $xfer += $output->writeFieldBegin('true_as_of_secs', TType::I32, 1);
      $xfer += $output->writeI32($this->true_as_of_secs);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

class Data {
  static $_TSPEC;

  public $pedigree = null;
  public $dataunit = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'pedigree',
          'type' => TType::STRUCT,
          'class' => 'Pedigree',
          ),
        2 => array(
          'var' => 'dataunit',
          'type' => TType::STRUCT,
          'class' => 'DataUnit',
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['pedigree'])) {
        $this->pedigree = $vals['pedigree'];
      }
      if (isset($vals['dataunit'])) {
        $this->dataunit = $vals['dataunit'];
      }
    }
  }

  public function getName() {
    return 'Data';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->pedigree = new Pedigree();
            $xfer += $this->pedigree->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::STRUCT) {
            $this->dataunit = new DataUnit();
            $xfer += $this->dataunit->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('Data');
    if ($this->pedigree !== null) {
      if (!is_object($this->pedigree)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('pedigree', TType::STRUCT, 1);
      $xfer += $this->pedigree->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->dataunit !== null) {
      if (!is_object($this->dataunit)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('dataunit', TType::STRUCT, 2);
      $xfer += $this->dataunit->write($output);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

?>
