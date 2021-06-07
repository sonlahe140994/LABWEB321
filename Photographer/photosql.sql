create table [image]
(
img_id int IDENTITY(1,1) PRIMARY KEY not null,
ga_id varchar(50) not null,
img_url varchar(max) not null
foreign key (ga_id) references gallery(ga_id)
)