-- 전체조회(25)
select * from oi_user;
select * from oi_recipe;
select * from oi_order;
select * from oi_material;
select * from oi_notice;
select * from oi_category;
select * from oi_recipe_material;
select * from oi_recipe_category;
select * from oi_follow;
select * from oi_comment;
select * from oi_product;
select * from oi_recipe_step;
select * from oi_notice_type;
select * from oi_qna;
select * from oi_level;
select * from oi_board_like;
select * from oi_basket;
select * from oi_refund;
select * from oi_report;
select * from oi_delivery_company;
select * from oi_payment;
select * from oi_account_transfer;
select * from oi_kakaopay;
select * from oi_order_list;
select * from oi_report_type;

-- Q/A
insert into oi_qna(qnano, uno, content, secret) values (1, 1, '테스트', 0);
insert into oi_qna(qnano, uno, content, secret) values (2, 2, '테스트2', 0);
insert into oi_qna(qnano, uno, content, secret) values (3, 3, '테스트3', 0);
insert into oi_qna(qnano, uno, content, secret) values (4, 4, '테스트4', 0);
insert into oi_qna(qnano, uno, content, secret) values (5, 5, '테스트5', 0);

-- 결제방법
insert into oi_payment(pno, name) values (1, 'accoTransfer');
insert into oi_payment(pno, name) values (2, 'kakaopay');
insert into oi_payment(pno, name) values (3, 'accoTransfer');
insert into oi_payment(pno, name) values (4, 'accoTransfer');

-- 배송사 
insert into oi_delivery_company(dcno, name) values (1, 'postOffice');
insert into oi_delivery_company(dcno, name) values (2, 'hanjin');
insert into oi_delivery_company(dcno, name) values (3, 'CJ');
insert into oi_delivery_company(dcno, name) values (4, 'postOffice');

-- 주문
insert into oi_order(odno, uno, pno, dcno, transno, memo, postno, addr, det_addr, stat) values (1, 1, 1, 1, '123-2345', '부재시 경비실', '10301','비트교육센터','로비','1');
insert into oi_order(odno, uno, pno, dcno, transno, memo, postno, addr, det_addr, stat) values (2, 2, 2, 2, '123-2345', '부재시 경비실', '10301','비트교육센터','203호','2');
insert into oi_order(odno, uno, pno, dcno, transno, memo, postno, addr, det_addr, stat) values (3, 3, 3, 3, '123-2345', '부재시 경비실', '10301','비트교육센터','204호','0');
insert into oi_order(odno, uno, pno, dcno, transno, memo, postno, addr, det_addr, stat) values (4, 4, 4, 4, '123-2345', '부재시 경비실', '10301','비트교육센터','205호','1');

-- 계좌이체
insert into oi_account_transfer(odno, name, account, bname) values (1, 'sejun', '3333-3333', 'hana');
insert into oi_account_transfer(odno, name, account, bname) values (2, 'eunchae', '3333-3333', 'hana');
insert into oi_account_transfer(odno, name, account, bname) values (3, 'aram', '3333-3333', 'hana');
insert into oi_account_transfer(odno, name, account, bname) values (4, 'hyuck', '3333-3333', 'hana');

-- 환불
insert into oi_refund(odno, pdt, stat) values (3, '2020-12-12', 1);

-- 재료
insert into oi_material(mno, name) value (1, '달걀');
insert into oi_material(mno, name) value (2, '사과');
insert into oi_material(mno, name) value (3, '양파');
insert into oi_material(mno, name) value (4, '돼지고기');
insert into oi_material(mno, name) value (5, '오징어');
insert into oi_material(mno, name) value (6, '배추');
insert into oi_material(mno, name) value (7, '고추');
insert into oi_material(mno, name) value (8, '닭고기');
insert into oi_material(mno, name) value (9, '소고기');
insert into oi_material(mno, name) value (10, '파');

-- 상품
insert into oi_product(pno, mno, content, stock, price, discount) value (1, 1, '지리산달걀', 50, 5000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (2, 2, '안성사과', 30, 10000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (3, 3, '양파', 100, 2000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (4, 4, '한돈돼지고기', 10, 30000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (5, 5, '주문진오징어', 50, 8000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (6, 6, '고랭지배추', 80, 3000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (7, 7, '오이고추', 100, 3000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (8, 8, '할라피뇨', 111, 5000, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (9, 9, '브라질닭', 30, 2700, 0);
insert into oi_product(pno, mno, content, stock, price, discount) value (10, 10, '평창한우', 10, 45000, 0);

-- 주문 항목
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (1, 1, 1, 3, 0, 5000);
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (2, 1, 2, 7, 0, 10000);
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (3, 1, 3, 10, 0, 2000);
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (4, 2, 4, 7, 0, 30000);
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (5, 2, 5, 4, 0, 8000);
insert into oi_order_list(olno, odno, pno, amount, discount, price) value (6, 2, 6, 5, 0, 3000);

-- 회원 
insert into oi_user(uno, name, nick, email, password, point, utype) values (1, 'sejunO', 'sj', 'sj@test.com', '1111', 0, 1);
insert into oi_user(uno, name, nick, email, password, point, utype) values (2, 'eunchae-Cho', 'ec', 'ec@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (3, 'aramYu', 'ar', 'ar@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (4, 'seunghyuck', 'sh', 'sh@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (5, 'jinyoungChoi', 'jy', 'jy@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (6, 'Test01', 't1', 't1@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (7, 'EomTeacher', 'et', 'et@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (8, 'Test02', 't2', 't2@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (9, 'Test03', 't3', 't3@test.com', '1111', 0, 0);
insert into oi_user(uno, name, nick, email, password, point, utype) values (10, 'youngjinEom', 'yj', 'yj@test.com', '1111', 0, 0);


-- 난이도번호
insert into oi_level(lno, lv) values (1, 1);
insert into oi_level(lno, lv) values (2, 2);
insert into oi_level(lno, lv) values (3, 3);
insert into oi_level(lno, lv) values (4, 4);
insert into oi_level(lno, lv) values (5, 5);

-- 게시글
insert into oi_recipe(rno, uno, title, content, photo, hits, rcmd, mdt, min, lno) values (1, 1, 'notice', '오호라', 'test.gif', 0, 0, '2020-11-18', 0, 1); 
insert into oi_recipe(rno, uno, title, content, photo, hits, rcmd, mdt, min, lno) values (2, 1, '제육볶음만들기', '첫번째,고기를산다', 'test1.gif', 0, 0, '2020-11-18 12:40:40', 40, 2); 
insert into oi_recipe(rno, uno, title, content, photo, hits, rcmd, mdt, min, lno) values (3, 2, '콩나물밥만들기', '콩나물을 산다', 'test2.gif', 2, 1, '2020-11-18 16:44:44', 60, 3); 
insert into oi_recipe(rno, uno, title, content, photo, hits, rcmd, mdt, min, lno) values (4, 3, '불닭만들기', '무조건맵게만든다', 'test3.gif', 3, 2, '2020-11-18 18:05:59', 40, 4); 
insert into oi_recipe(rno, uno, title, content, photo, hits, rcmd, mdt, min, lno) values (5, 4, '계란찜만들기', '계란을산다', 'test4.gif', 4, 3, '2020-11-18 20:24:32', 20, 5); 

-- 레시피 단계
insert into oi_recipe_step(rsno, rno, step, photo, content) values (1, 1, 1, 'hi.jpg', '1단계 입니다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (2, 1, 2, 'hi2.jpg', '2단계 입니다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (3, 1, 3, 'hi3.jpg', '3단계 입니다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (4, 1, 4, 'hi4.jpg', '4단계 입니다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (5, 1, 5, 'hi5.jpg', '5단계 입니다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (6, 2, 1, 'hi.jpg', '1단계 고기산다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (7, 2, 2, 'hi2.jpg', '2단계 양념을재운다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (8, 2, 3, 'hi3.jpg', '3단계 냉동실에숙성한다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (9, 2, 4, 'hi4.jpg', '4단계 볶는다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (10, 2, 5, 'hi5.jpg', '5단계 먹는다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (11, 3, 1, 'hi.jpg', '1단계 콩나물을산다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (12, 3, 2, 'hi2.jpg', '2단계 콩나물을씻는다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (13, 3, 3, 'hi3.jpg', '3단계 콩나물과밥한다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (14, 3, 4, 'hi4.jpg', '4단계 양념장을만든다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (15, 3, 5, 'hi5.jpg', '5단계 먹는다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (16, 4, 1, 'hi.jpg', '1단계 닭을산다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (17, 4, 2, 'hi2.jpg', '2단계 우유에재운다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (18, 4, 3, 'hi3.jpg', '3단계 양념해서볶는다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (19, 5, 1, 'hi.jpg', '1단계 계란을산다');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (20, 5, 2, 'hi2.jpg', '2단계 계란을깨고소금간한다.');
insert into oi_recipe_step(rsno, rno, step, photo, content) values (21, 5, 3, 'hi3.jpg', '3단계 냄비에찐다');

-- 댓글
insert into oi_comment(cno, uno, rno, content) values (1, 1, 1, '첫 댓글');
insert into oi_comment(cno, uno, rno, content) values (2, 1, 2, '안녕하세요. 오세준입니다.');
insert into oi_comment(cno, uno, rno, content) values (3, 1, 3, '안녕하세요. 치어리더입니다.');
insert into oi_comment(cno, uno, rno, content) values (4, 1, 4, '클린하게 댓글달아 주세요.');
insert into oi_comment(cno, uno, rno, content) values (5, 1, 5, '안녕하세요. 관리자입니다.');
insert into oi_comment(cno, uno, rno, content) values (6, 2, 2, '맛있어 보여요.');
insert into oi_comment(cno, uno, rno, content) values (7, 3, 3, '오늘 저녁은 이거다');
insert into oi_comment(cno, uno, rno, content) values (8, 4, 3, '와 대박.');
insert into oi_comment(cno, uno, rno, content) values (9, 5, 4, '다들 맛점하세요.');
insert into oi_comment(cno, uno, rno, content) values (10, 6, 5, '오늘도 불금보내세요.');

-- 팔로잉
insert into oi_follow(follower, following) values (2 ,1);
insert into oi_follow(follower, following) values (3 ,1);
insert into oi_follow(follower, following) values (4 ,1);
insert into oi_follow(follower, following) values (5 ,1);
insert into oi_follow(follower, following) values (6 ,1);
insert into oi_follow(follower, following) values (7 ,1);
insert into oi_follow(follower, following) values (8 ,1);
insert into oi_follow(follower, following) values (9 ,1);
insert into oi_follow(follower, following) values (10 ,1);
insert into oi_follow(follower, following) values (1 ,10);

-- 요리유형
insert into oi_category(cno, name) values (1, '메인요리');
insert into oi_category(cno, name) values (2, '밑반찬');
insert into oi_category(cno, name) values (3, '국/찌개');
insert into oi_category(cno, name) values (4, '면/만두');
insert into oi_category(cno, name) values (5, '밥/죽/떡');
insert into oi_category(cno, name) values (6, '김치/젓갈');
insert into oi_category(cno, name) values (7, '양념/소스');
insert into oi_category(cno, name) values (8, '디저트');
insert into oi_category(cno, name) values (9, '빵/과자');
insert into oi_category(cno, name) values (10, '스프');
insert into oi_category(cno, name) values (11, '샐러드');
insert into oi_category(cno, name) values (12, '기타');

-- 레시피요리유형
insert into oi_recipe_category(rno, cno) values (1, 12);
insert into oi_recipe_category(rno, cno) values (2, 1);
insert into oi_recipe_category(rno, cno) values (3, 5);
insert into oi_recipe_category(rno, cno) values (4, 1);
insert into oi_recipe_category(rno, cno) values (5, 3);

-- 레시피재료
insert into oi_recipe_material(mno, rno) values (4, 2);
insert into oi_recipe_material(mno, rno) values (3, 2);
insert into oi_recipe_material(mno, rno) values (10, 2);
insert into oi_recipe_material(mno, rno) values (7, 2);
insert into oi_recipe_material(mno, rno) values (2, 3);
insert into oi_recipe_material(mno, rno) values (8, 4);
insert into oi_recipe_material(mno, rno) values (7, 4);
insert into oi_recipe_material(mno, rno) values (1, 5);
insert into oi_recipe_material(mno, rno) values (10, 5);

-- 카카오페이
insert into oi_kakaopay(odno, name, account) values (1, 'sejun', '7777-7777-7777');
insert into oi_kakaopay(odno, name, account) values (2, 'eunchae', '7777-7777-7777');
insert into oi_kakaopay(odno, name, account) values (3, 'aram', '7777-7777-7777');
insert into oi_kakaopay(odno, name, account) values (4, 'hyuck', '7777-7777-7777');

-- 장바구니
insert into oi_basket(bkno, pno, amount, uno) values (1, 4, 1, 1);
insert into oi_basket(bkno, pno, amount, uno) values (2, 2, 1, 2);
insert into oi_basket(bkno, pno, amount, uno) values (3, 9, 3, 10);
insert into oi_basket(bkno, pno, amount, uno) values (4, 1, 2, 7);

-- 게시글좋아요
insert into oi_board_like(uno, rno) values (1, 1);
insert into oi_board_like(uno, rno) values (2, 1);
insert into oi_board_like(uno, rno) values (3, 1);
insert into oi_board_like(uno, rno) values (4, 3);
insert into oi_board_like(uno, rno) values (5, 5);
