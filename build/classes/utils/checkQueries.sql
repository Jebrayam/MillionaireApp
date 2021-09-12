select * from player;
select * from game;
select * from partialG;

delete from game;
delete from partialgame;
delete from player;

select * from roundT;
select * from question;
select * from optionT ;
select * from partialgame;

select rou_id, rou_category, rou_reward from roundT where rou_id= 1;

select que_id, que_questionText, que_rou_id from question where que_id= 2;

select opt_id, opt_optionText, opt_correctOption, opt_que_id from optionT where opt_que_id = 1;

insert into partialGame(pag_wonRound, pag_pla_id, pag_gam_id, pag_rou_id) values(1,7,7,1);

select rou_reward
from partialG join roundT on rou_id = pag_rou_id
where (pag_gam_id = 1 and pag_wonRound=1);