BEGIN
	DECLARE v_no VARCHAR(10) ;
	DECLARE v_cnt BIGINT;
	DECLARE v_id BIGINT;
	DECLARE v_format VARCHAR(20) DEFAULT 'FM9999';
	DECLARE v_x BIGINT DEFAULT 0;
	DECLARE v_no_length BIGINT DEFAULT 6;
	SELECT COUNT(id) INTO v_cnt FROM bis_no WHERE main_type=p_main_type AND second_type=p_second_type AND main_prefix=p_main_prefix AND second_prefix=p_second_prefix AND date_prefix=p_date_prefix;
	IF v_cnt = 0 THEN
	INSERT INTO bis_no(main_type, second_type, main_prefix, second_prefix, date_prefix, seq_no) VALUES(p_main_type, p_second_type, p_main_prefix, p_second_prefix, p_date_prefix, 1);
	SET v_id=LAST_INSERT_ID();
	END IF;
	IF v_id IS NULL THEN
	SELECT id INTO v_id FROM bis_no WHERE main_type=p_main_type AND second_type=p_second_type AND main_prefix=p_main_prefix AND second_prefix=p_second_prefix AND date_prefix=p_date_prefix;
	END IF;
	IF p_no_length IS NOT NULL AND p_no_length <> v_no_length THEN
	SET v_no_length = p_no_length;
	END IF;
	/*
	WHILE v_x < v_no_length
	SET v_format = CONCAT(v_format,'0');
	SET v_x = v_x + 1;
	END WHILE;*/
	SELECT LPAD(seq_no,v_no_length, '0') INTO v_no FROM bis_no WHERE id=v_id FOR UPDATE; /** ����,��ֹ�ظ���ˮ�� */
	UPDATE bis_no SET seq_no=seq_no + 1 WHERE id=v_id;
	RETURN v_no;
END


BEGIN
	DECLARE v_date_prefix VARCHAR(15);
	DECLARE v_no VARCHAR(50);
	SET v_date_prefix = DATE_FORMAT(NOW(),'%Y%m%d%H%i%S');
	SET v_no = FN_GENERATE_NO(p_main_type, p_second_type, p_main_prefix, p_second_prefix, v_date_prefix, p_no_length);
	SET ret_code = CONCAT(p_main_prefix,p_second_prefix,v_date_prefix,v_no);
END