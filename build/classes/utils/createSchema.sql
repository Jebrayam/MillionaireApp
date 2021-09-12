create schema millionaireDB;
use millionaireDB;

drop table if exists partialG;
drop table if exists player;
drop table if exists game;
drop table if exists optionT;
drop table if exists question;
drop table if exists roundT;

create table player(
	pla_id int not null auto_increment primary key,
    pla_name char(50)
);

create table game(
	gam_id int auto_increment primary key,
    game_date datetime
);

create table roundT(
	rou_id int auto_increment primary key,
    rou_category char(20),
    rou_reward double
);
insert into roundT(rou_category, rou_reward) values ("Very easy", 70000);
insert into roundT(rou_category, rou_reward) values ("Easy", 130000);
insert into roundT(rou_category, rou_reward) values ("Medium", 300000);
insert into roundT(rou_category, rou_reward) values ("A bit difficult", 450000);
insert into roundT(rou_category, rou_reward) values ("Difficult", 1050000);


create table partialG(
	pag_id int auto_increment primary key,
    pag_wonRound int,
    pag_pla_id int,
    pag_gam_id int,
    pag_rou_id int,
	foreign key(pag_pla_id) references player(pla_id),
    foreign key(pag_gam_id) references game(gam_id)    ,
    foreign key(pag_rou_id) references roundT(rou_id)
);

create table question(
		que_id int auto_increment primary key,
        que_questionText char(200),
        que_rou_id int,
        foreign key(que_rou_id) references roundT(rou_id)
);
insert into question(que_questionText, que_rou_id) values("What continent is Ecuador on?", 1);
insert into question(que_questionText, que_rou_id) values("What is the coldest place on earth?", 1);
insert into question(que_questionText, que_rou_id) values("Where is the famous Eiffel Tower located?", 1);
insert into question(que_questionText, que_rou_id) values("What is the third planet in the solar system?", 1);
insert into question(que_questionText, que_rou_id) values("How many legs does a spider have?", 1);
insert into question(que_questionText, que_rou_id) values("What is the name of the official language in China?", 2);
insert into question(que_questionText, que_rou_id) values("What is the official currency of the United States?", 2);
insert into question(que_questionText, que_rou_id) values("Whose nose grew when he lied?", 2);
insert into question(que_questionText, que_rou_id) values("Where is the White House?", 2);
insert into question(que_questionText, que_rou_id) values("What sport does Roger Federer practice professionally?", 2);
insert into question(que_questionText, que_rou_id) values("What is the name of the founder of Facebook?", 3);
insert into question(que_questionText, que_rou_id) values("Which national team has won the most Soccer World Cups?", 3);
insert into question(que_questionText, que_rou_id) values("In what year did human beings reach the Moon?", 3);
insert into question(que_questionText, que_rou_id) values("How many sides does a hexagon have?", 3);
insert into question(que_questionText, que_rou_id) values("What is the largest organ of the human body?", 3);
insert into question(que_questionText, que_rou_id) values("What is the country in America with the largest population?", 4);
insert into question(que_questionText, que_rou_id) values("Who wrote The Odyssey?", 4);
insert into question(que_questionText, que_rou_id) values("What is the longest river in the world?", 4);
insert into question(que_questionText, que_rou_id) values("How many bones are in the human body?", 4);
insert into question(que_questionText, que_rou_id) values("When did World War II end?", 4);
insert into question(que_questionText, que_rou_id) values("What is the largest ocean?", 5);
insert into question(que_questionText, que_rou_id) values("What year did Christopher Columbus arrive in America?", 5);
insert into question(que_questionText, que_rou_id) values("What is the name of the fastest animal in the world?", 5);
insert into question(que_questionText, que_rou_id) values("What was the first metal that man used?", 5);
insert into question(que_questionText, que_rou_id) values("What is the first in the list of prime numbers?", 5);

create table optionT(
	opt_id int auto_increment primary key,
    opt_optionText char(20),
    opt_correctOption int,
    opt_que_id int,
    foreign key(opt_que_id) references question(que_id)
);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("America", 1, 1);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Europa", 0, 1);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Asia", 0, 1);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Africa", 0, 1);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Siberia", 0, 2);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Norway", 0, 2);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Antarctica", 1, 2);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Sahara", 0, 2);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Moscow", 0, 3);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Paris", 1, 3);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("New York", 0, 3);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Bogota", 0, 3);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Earth", 1, 4);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Venus", 0, 4);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Mars", 0, 4);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Saturn", 0, 4);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cuatro", 0, 5);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Dos", 0, 5);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Ocho", 1, 5);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Diez", 0, 5);

insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("French", 0, 6);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Mandarin", 1, 6);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Spanish", 0, 6);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("English", 0, 6);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Euro", 0, 7);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Pound", 0, 7);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Yen", 0, 7);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Dollar", 1, 7);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Pinocchio", 1, 8);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Goku", 0, 8);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Homer", 0, 8);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Tony Stark", 0, 8);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cali", 0, 9);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Rome", 0, 9);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Washington D.C.", 1, 9);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Tokyo", 0, 9);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Tennis", 1, 10);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Volleyball", 0, 10);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Rugby", 0, 10);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Ping Pong", 0, 10);

insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Jeff Bezos", 0, 11);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Mark Zuckerberg", 1, 11);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Larry Page", 0, 11);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Elon Musk", 0, 11);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Colombia", 0, 12);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Brazil", 1, 12);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Senegal", 0, 12);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Italy", 0, 12);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("2020", 0, 13);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1961", 0, 13);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1969", 1, 13);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1980", 0, 13);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Dos", 0, 14);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cuatro", 0, 14);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Ocho", 0, 14);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Seis", 1, 14);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Brain", 0, 15);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Heart", 0, 15);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Skin", 1, 15);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Lungs", 0, 15);

insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Brazil", 0, 16);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("USA", 1, 16);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Colombia", 0, 16);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Canada", 0, 16);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Homer", 1, 17);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Orwell", 0, 17);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Shakespeare ", 0, 17);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Dante", 0, 17);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cauca", 0, 18);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Amazon", 0, 18);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Nile", 1, 18);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Mississippi", 0, 18);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("300", 0, 19);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("255", 0, 19);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("181", 0, 19);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("206", 1, 19);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("2000", 0, 20);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1918", 0, 20);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1945", 1, 20);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1976", 0, 20);

insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Atlantic ", 0, 21);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Indian", 0, 21);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Pacific", 1, 21);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Artic", 0, 21);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1600", 0, 22);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1810", 0, 22);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1398", 0, 22);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("1492", 1, 22);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cheetah", 1, 23);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Lion", 0, 23);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Wolf", 0, 23);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Eagle", 0, 23);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Iron", 0, 24);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Copper", 1, 24);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Gold", 0, 24);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Aluminum", 0, 24);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Dos", 1, 25);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Cinco", 0, 25);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Tres", 0, 25);
insert into optionT(opt_optionText, opt_correctOption, opt_que_id) values ("Siete", 0, 25);
