delete from Value where code = 1000 or code = 1001;
delete from Holder where code = 1000 or code = 1001;
insert into Holder values(1, '2011-09-27', 1000, 'Съобщения', 'Messages');
insert into Value values (1, '2011-09-27', 'Грешно потребителско име и/или парола', 'loginFailed', 'Wrong username and/or password', 1000);
insert into Value values (2, '2011-09-27', 'Грешен защитен код', 'captchaNotMatching', 'CAPTCHA doesn''t match', 1000);
insert into Value values (3, '2011-09-27', 'Не е въведен защитен код', 'captchaMissing', 'CAPTCHA is required', 1000);
insert into Value values (4, '2011-09-27', 'Моля въведете адрес', 'address', 'Please add your address', 1000);
insert into Value values (5, '2011-09-27', 'Моля въведете пощески адрес', 'e-mail', 'Please add e-mail address', 1000);
insert into Value values (6, '2011-09-27', 'Моля въведете парола', 'password', 'Please write password', 1000);
insert into Value values (7, '2011-09-27', 'Повторете паролата', 'retypePassword', 'Please retype password', 1000);
insert into Value values (8, '2011-09-27', 'Задачата е успешно създадена!', 'completeCreateIssue', 'Issue created!', 1000);
insert into Value values (9, '2011-09-27', 'Регистрацията е успешна!', 'completeRegistration', 'You are now registered!', 1000);
insert into Value values (10, '2011-09-27', 'Моля попълнете си адресната информация за да завършите регистрацията', 'alert', 'Please remember to fill your address information to complete registration', 1000);
insert into Holder values(2, '2011-09-27', 1001, 'Етикети', 'Labels');
insert into Value values (11, '2011-09-27', 'Трите имена', 'fullName', 'Full name', 1001);
insert into Value values (12, '2011-09-27', 'Изглед на продукта', 'shopProductScreen', 'Product View', 1001);
insert into Value values (13, '2011-09-27', 'Софтуерни продукти', 'shopSoftwareProducts', 'Software products', 1001);
insert into Value values (14, '2011-09-27', 'Хардуерни продукти', 'shopHardwareProducts', 'Hardware products', 1001);
insert into Value values (15, '2011-09-27', 'Име и описание', 'shopNameDescription', 'Name and description', 1001);
insert into Value values (16, '2011-09-27', 'Купи', 'shopBuy', 'Buy', 1001);
insert into Value values (17, '2011-09-27', 'Брой продукти', 'shopItemNumber', 'Item number', 1001);
insert into Value values (18, '2011-09-27', 'Обща сума', 'shopTotalPrice', 'Total price', 1001);
insert into Value values (19, '2011-09-27', 'Изчисти', 'shopClear', 'Clear', 1001);
insert into Value values (20, '2011-09-27', 'Кошница с покупки', 'shopCart', 'Shopping Cart', 1001);
insert into Value values (21, '2011-09-27', 'Избор на Проект', 'searchProject', 'Search Project', 1001);
insert into Value values (22, '2011-09-27', 'код', 'id', 'Id', 1001);
insert into Value values (23, '2011-09-27', 'Търсене на задача', 'issueSearch', 'Issue Search', 1001);
insert into Value values (24, '2011-09-27', 'Начало', 'home', 'home', 1001);
insert into Value values (25, '2011-09-27', 'Форум', 'forum', 'forum', 1001);
insert into Value values (26, '2011-09-27', 'Въпроси и отговори', 'FAQ', 'FAQ', 1001);
insert into Value values (27, '2011-09-27', 'Магазин', 'shop', 'e-shop', 1001);
insert into Value values (28, '2011-09-27', 'Контакти', 'contactUs', 'contact us', 1001);
insert into Value values (29, '2011-09-27', 'Решение', 'issueDecision', 'Decision', 1001);
insert into Value values (30, '2011-09-27', 'Приоритет', 'issuePriority', 'Priority', 1001);
insert into Value values (31, '2011-09-27', 'Дата на създаване', 'issueCreateDate', 'Create date', 1001);
insert into Value values (32, '2011-09-27', 'Редактирай', 'edit', 'Edit', 1001);
insert into Value values (33, '2011-09-27', 'Запази', 'save', 'Save', 1001);
insert into Value values (34, '2011-09-27', 'Заглавие', 'threadTitle', 'Title', 1001);
insert into Value values (35, '2011-09-27', 'Дати', 'date', 'Date', 1001);
insert into Value values (36, '2011-09-27', 'Регистрацията е приключена, изпратена е електронна поща за проверка', 'compReg', 'Registration done, e-mail for verification sent', 1001);
insert into Value values (37, '2011-09-27', 'Детайли на задача', 'issueDetail', 'Issue detail', 1001);
insert into Value values (38, '2011-09-27', 'Дата от', 'dateFrom', 'Date from', 1001);
insert into Value values (39, '2011-09-27', 'Дата до', 'dateTo', 'Date to', 1001);
insert into Value values (40, '2011-09-27', 'Намерен резултат', 'issueResult', 'Results found', 1001);
insert into Value values (41, '2011-09-27', 'Отказ', 'issueCancel', 'Cancel', 1001);
insert into Value values (42, '2011-09-27', 'Търсене на потребители', 'userSearch', 'User search', 1001);
insert into Value values (43, '2011-09-27', 'Община', 'municipality', 'Municipality', 1001);
insert into Value values (44, '2011-09-27', 'Тип на потребител', 'userType', 'User type', 1001);
insert into Value values (45, '2011-09-27', 'Вход', 'loginTitle', 'Login', 1001);
insert into Value values (46, '2011-09-27', 'Държава', 'country', 'Country', 1001);
insert into Value values (47, '2011-09-27', 'Избери опция', 'choiceOption', 'Choice option', 1001);
insert into Value values (48, '2011-09-27', 'Град', 'city', 'City', 1001);
insert into Value values (49, '2011-09-27', 'Пощенски код', 'postCode', 'Post Code', 1001);
insert into Value values (50, '2011-09-27', 'Телефон за връзка', 'phone', 'Phone ', 1001);
insert into Value values (51, '2011-09-27', 'Създаване на проект', 'projectCreate', 'Create Project', 1001);
insert into Value values (52, '2011-09-27', 'Фирма', 'company', 'Company', 1001);
insert into Value values (53, '2011-09-27', 'Име', 'name', 'Name', 1001);
insert into Value values (54, '2011-09-27', 'Описание', 'description', 'Description', 1001);
insert into Value values (55, '2011-09-27', 'Привилегии', 'privileges', 'Privileges', 1001);
insert into Value values (56, '2011-09-27', 'Проект', 'projectName', 'Project name', 1001);
insert into Value values (57, '2011-09-27', 'Детайли на проект', 'projectDetail', 'Project detail', 1001);
insert into Value values (58, '2011-09-27', 'Кратко име ', 'shortProjectName', 'Short name', 1001);
insert into Value values (59, '2011-09-27', 'Описание', 'privilegesDescription', 'Privileges Description', 1001);
insert into Value values (60, '2011-09-27', 'Регистрация на потребител', 'userRegistration', 'User Registration', 1001);
insert into Value values (61, '2011-09-27', 'Добавяне на потребител/служител', 'newUserEmployee', 'New user/employee', 1001);
insert into Value values (62, '2011-09-27', 'Добавяне на потребителска група', 'newUserGroup', 'New user/group', 1001);
insert into Value values (63, '2011-09-27', 'Добавяне на продукт', 'newProduct', 'New product', 1001);
insert into Value values (64, '2011-09-27', 'Софтуер', 'software', 'Software', 1001);
insert into Value values (65, '2011-09-27', 'Наименование', 'productName', 'Product Name ', 1001);
insert into Value values (66, '2011-09-27', 'Сериен №', 'serialNumber', 'Serial Number', 1001);
insert into Value values (67, '2011-09-27', 'Версия', 'version', 'Version', 1001);
insert into Value values (68, '2011-09-27', 'Снимка', 'image', 'Image', 1001);
insert into Value values (69, '2011-09-27', 'Създаване на задача', 'issueCreate', 'Issue create ', 1001);
insert into Value values (70, '2011-09-27', 'Цена', 'price', 'Price', 1001);
insert into Value values (71, '2011-09-27', 'Хардуер', 'hardware', 'Hardware', 1001);
insert into Value values (72, '2011-09-27', 'Заглавие на задачата', 'issueTask', 'Task title', 1001);
insert into Value values (73, '2011-09-27', 'Номер', 'issueNumber', 'Number', 1001);
insert into Value values (74, '2011-09-27', 'Създадено от', 'issueCreatedFrom', 'Created by', 1001);
insert into Value values (75, '2011-09-27', 'Генерирай', 'generate', 'Generate', 1001);
insert into Value values (76, '2011-09-27', 'Принтиране', 'print', 'Print', 1001);
insert into Value values (77, '2011-09-27', 'Назначено на', 'issueOwnerCreate', 'Appointed on', 1001);
insert into Value values (78, '2011-09-27', 'Производител', 'manufacturer', 'Manufacturer', 1001);
insert into Value values (79, '2011-09-27', 'Статус', 'issueStatus', 'Status', 1001);
insert into Value values (80, '2011-09-27', 'Гаранционен период', 'warranity', 'Warranity', 1001);
insert into Value values (81, '2011-09-27', 'Тегло', 'weight', 'Weight', 1001);
insert into Value values (82, '2011-09-27', 'Добавяне на фирма', 'newCompany', 'New company', 1001);
insert into Value values (83, '2011-09-27', 'Потребител', 'user', 'User', 1001);
insert into Value values (84, '2011-09-27', 'Служител', 'employee', 'Employee', 1001);
insert into Value values (85, '2011-09-27', 'Търсене на потребител/служител', 'searchUserEmployee', 'Search user/employee', 1001);
insert into Value values (86, '2011-09-27', 'Търсене на продукт', 'searchProduct', 'Search product', 1001);
insert into Value values (87, '2011-09-27', 'Булстат', 'bulstat', 'Bulstat', 1001);
insert into Value values (88, '2011-09-27', 'Представители', 'representatives', 'Representatives', 1001);
insert into Value values (89, '2011-09-27', 'Търсене', 'search', 'Search', 1001);
insert into Value values (90, '2011-09-27', 'Интернет адрес', 'webSite', 'Web Site', 1001);
insert into Value values (91, '2011-09-27', 'Търсене на фирма', 'searchCompany', 'Search company', 1001);
insert into Value values (92, '2011-09-27', 'Продукт', 'product', 'Product', 1001);
insert into Value values (93, '2011-09-27', 'Улица', 'street', 'Street', 1001);
insert into Value values (94, '2011-09-27', 'Парола', 'password', 'Password', 1001);
insert into Value values (95, '2011-09-27', 'Имейл Адрес', 'email', 'E-mail Address', 1001);
insert into Value values (96, '2011-09-27', 'Адрес', 'address', 'Address', 1001);
insert into Value values (97, '2011-09-27', 'Регистрация', 'registration', 'Registration', 1001);
insert into Value values (98, '2011-09-27', 'Създай задача', 'createIssue', 'Create', 1001);
insert into Value values (99, '2011-09-27', 'Отказ', 'cancel', 'Cancel', 1001);
insert into Value values (100, '2011-09-27', 'Тип задача', 'type', 'Type Issue', 1001);
insert into Value values (101, '2011-09-27', 'Приоритет', 'priority', 'Priority', 1001);
insert into Value values (102, '2011-09-27', 'Статус', 'status', 'Status', 1001);
insert into Value values (103, '2011-09-27', 'Решение', 'resolution', 'Resolution', 1001);
insert into Value values (104, '2011-09-27', 'Възложител', 'reporter', 'Reporter', 1001);
insert into Value values (105, '2011-09-27', 'Изпълнител', 'assignee', 'Assignee', 1001);
insert into Value values (106, '2011-09-27', 'Дата на създаване', 'dateCreated', 'Date Created', 1001);
insert into Value values (107, '2011-09-27', 'Крайна дата', 'dateEnded', 'Date Ended', 1001);
insert into Value values (108, '2011-09-27', 'Бъг', 'bug', 'Bug', 1001);
insert into Value values (109, '2011-09-27', 'Подобрение', 'improvement', 'Improvement', 1001);
insert into Value values (110, '2011-09-27', 'Ново свойство', 'newFeature', 'New Feature', 1001);
insert into Value values (111, '2011-09-27', 'Задача', 'task', 'Task', 1001);
insert into Value values (112, '2011-09-27', 'Важен', 'major', 'Major', 1001);
insert into Value values (113, '2011-09-27', 'Маловажен', 'minor', 'Minor', 1001);
insert into Value values (114, '2011-09-27', 'Незначителен', 'trivial', 'Trivial', 1001);
insert into Value values (115, '2011-09-27', 'Отворен ', 'open', 'Open', 1001);
insert into Value values (116, '2011-09-27', 'В прогрес', 'inProgress', 'In Progress', 1001);
insert into Value values (117, '2011-09-27', 'Решен', 'resolved', 'Resolved', 1001);
insert into Value values (118, '2011-09-27', 'Подновен ', 'reopened', 'Reopened', 1001);
insert into Value values (119, '2011-09-27', 'Затворен', 'closed', 'Closed', 1001);
insert into Value values (120, '2011-09-27', 'Установено', 'fixed', 'Fixed', 1001);
insert into Value values (121, '2011-09-27', 'Няма решение', 'woNotFix', 'Won''t Fix', 1001);
insert into Value values (122, '2011-09-27', 'Повторение', 'duplicate', 'Duplicate', 1001);
insert into Value values (123, '2011-09-27', 'Служители', 'staff', 'Staff', 1001);
insert into Value values (124, '2011-09-27', 'Незавършен', 'incomplete', 'Incomplete', 1001);
insert into Value values (125, '2011-09-27', 'Невъзпроизводим', 'cannotReproduce', 'Cann''t Reproduce', 1001);
insert into Value values (126, '2011-09-27', 'Задача по поръчка', 'customIssue', 'Custom Issue', 1001);
insert into Value values (127, '2011-09-27', 'Критично', 'critical', 'Critical', 1001);
insert into Value values (128, '2011-09-27', 'Потвърди парола', 'confirmPassword', 'Confirm Password', 1001);
insert into Value values (129, '2011-09-27', 'Заглавие на задача', 'titleIssue', 'Тitle Issue', 1001);
insert into Value values (130, '2011-09-27', 'Отчет задачи?', 'issueReport', 'Issue Report', 1001);
insert into Value values (131, '2011-09-27', 'наименование', 'groupName', 'Group Name', 1001);
insert into Value values (132, '2011-09-27', 'Продукти', 'products', 'Products', 1001);
insert into Value values (133, '2011-09-27', 'Влез', 'login', 'Login', 1001);
insert into Value values (134, '2011-09-27', 'Излез', 'logout', 'Logout', 1001);
insert into Value values (135, '2011-09-27', 'Профил', 'profile', 'Profile', 1001);
insert into Value values (136, '2011-09-27', 'Лична информация', 'generalInformation', 'General information', 1001);
insert into Value values (137, '2011-09-27', 'Роля', 'role', 'Role', 1001);
insert into Value values (138, '2011-09-27', 'Фирми', 'companies', 'Companies', 1001);
insert into Value values (139, '2011-09-27', 'Добави Фирми', 'associateCompanies', 'Associate Companies', 1001);
insert into Value values (140, '2011-09-27', 'Добави/Премахни', 'addRemove', 'Add/Remove', 1001);
insert into Value values (141, '2011-09-27', 'Добави', 'add', 'Add', 1001);
insert into Value values (142, '2011-09-27', 'Премахни', 'remove', 'Remove', 1001);
