delete from Value where code = 1000 or code = 1001;
delete from Holder where code = 1000 or code = 1001;insert into Holder values(1, '2011-09-24', 1000, 'Съобщения', 'Messages');
insert into Value values (1, '2011-09-24', 'Грешно потребителско име и/или парола', 'loginFailed', 'Wrong username and/or password', 1000);
insert into Value values (2, '2011-09-24', 'Грешен защитен код', 'captchaNotMatching', 'CAPTCHA doesn''t match', 1000);
insert into Value values (3, '2011-09-24', 'Не е въведен защитен код', 'captchaMissing', 'CAPTCHA is required', 1000);
