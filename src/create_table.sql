create table domain (
	domain_id varchar2(24) primary key,
	domain_name varchar2(16) not null,
	status varchar2(16) not null
);

create table domain_env (
	domain_id varchar2(24) primary key references domain(domain_id),
	project varchar2(16),
	env varchar2(16),
	vlan varchar2(8) constraint vlan_choice check(vlan in ('Global','Local','DMZ')),
	pod varchar2(16) constraint pod_choice check(pod in ('Advisor','Consumer','Batch')),
	application varchar2(24),
	component varchar2(24)
);

create table domain_general (
	domain_id varchar2(24) primary key references domain(domain_id),
	weblogic_user varchar2(16) not null,
	weblogic_password varchar2(16) not null,
	app_os_user varchar2(16) not null,
	app_os_password varchar2(16) not null,
	software varchar2(16) not null,
	software_version varchar2(16) not null,
	jdk_version varchar2(16) not null
);

create table domain_server (
	server_num number(3) not null,
	domain_id varchar2(24) references domain(domain_id),
	instance_type varchar2(16) not null,
	ip_address varchar2(16) not null,
	http_port number(5) not null,
	https_port number(5) not null,
	cluster_name varchar2(16),
	vm_name varchar2(24) not null,
	log_dir varchar(64),
	xms number(5),
	xmx number(5),
	xmn number(5),
	max_perm_size number(5),
	constraint primary_key primary key(server_num, domain_id)
);