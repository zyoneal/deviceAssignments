create table departments(
   id serial,
   title varchar(255) not null,
   constraint departments_title_unique unique(title),
   constraint departments_id_pk primary key(id));

create table employees(
   id serial,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   hire_date date not null,
   constraint employees_id_pk primary key(id),
   department_id int not null,
   constraint employee_unique unique(first_name, last_name, hire_date),
   constraint employee_department_id foreign key (department_id) references departments(id));

create type status as enum ('IN USE', 'AVAILABLE', 'LOST');

create type type as enum('KEYBOARD', 'LAPTOP', 'HEADPHONE', 'MOUSE', 'SCREEN');

create table assets(
   id serial,
   title varchar(255) not null,
   employee_id int null,
   created_on date not null,
   sent_at date null check(created_on < sent_at),
   asset_type type not null,
   asset_status status not null,
   returned boolean default(true),
   constraint assets_id_pk primary key(id),
   constraint assets_employee_id_fk foreign key(employee_id) references employees(id));

create table assets_history(
   id serial,
   asset_id int not null,
   previous_owner_id int null,
   current_owner_id int not null,
   updated_on timestamp not null default now(),
   constraint assets_history_id_pk primary key(id),
   constraint assets_history_current_owner_id_fk foreign key(current_owner_id) references employees(id),
   constraint assets_history_previous_owner_id_fk foreign key(previous_owner_id) references employees(id),
   constraint assets_history_asset_id_fk foreign key(asset_id) references assets(id)
);
