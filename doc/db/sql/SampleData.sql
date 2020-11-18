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



