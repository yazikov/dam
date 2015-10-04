create table PASSPORT_PARAM_SYS
(
  OBJ_MONITOR VARCHAR(40),
  MEAS_PARAM_TYPE_SIG INTEGER,
  NAME_SENSORS VARCHAR(10),
  SORT_SIGN VARCHAR(100),
  TYPE_OF_SENSOR VARCHAR(50),
  NUMBER_OF_SENSOR VARCHAR(40),
  ID_SENSORS INTEGER,
  primary key(ID_SENSORS)
);

create table TYPE_SIGNAL_TABLE(
  ID_SIGNAL Integer,
  TEXT_SIGNAL VARCHAR(50),
  primary key(ID_SIGNAL)
);

create table USTAVKA_PARAM_SYS
(
  ID_USTAVKA VARCHAR(50),
  DATE_USTAVKA DATE,
  VALUE_USTAVKA_PRE FLOAT,
  VALUE_USTAVKA_AV FLOAT,
  COEFF_RETURN FLOAT,
  primary key(ID_USTAVKA)
);

create table MEAS_PARAM_SYS
(
  ID_SENSORS INTEGER,
  STATUS_SENSORS INTEGER,
--   1)роботоспособен 2)отказ 3)замаскирован
--   реальный или вертуальный не требуется SORT_SENSORS INTEGER,
  DATE_MEAS DATE,
  TIME_MEAS TIME,
  VALUE_MEAS float,
  RELATIVE_VALUE_MEAS float,
  TRUST_MEAS INTEGER,
  WORK_SENSORS  boolean,
  primary key(ID_SENSORS),
  foreign key(ID_SENSORS) references  PASSPORT_PARAM_SYS(ID_SENSORS) on delete cascade
);

create table SIGN_SYS
(
  ID_SIGN SERIAL,
  DATE_SIGN DATE,
  TIME_SIGN TIME,
  SORT_SIGN INTEGER,
  ID_SENSORS  INTEGER,
  primary key(ID_SIGN),
  foreign key(ID_SENSORS) references  PASSPORT_PARAM_SYS(ID_SENSORS) on delete cascade
);


create table MEAS_PARAM_TYPE_SIG
(
  ID_TYPE INTEGER,
  DISCRIPTION VARCHAR(40),
  PRIMARY KEY(ID_TYPE)
);