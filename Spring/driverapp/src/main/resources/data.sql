-- 권한
-- INSERT INTO 권한 (authority_name) VALUES ('ADMIN');
-- INSERT INTO 권한 (authority_name) VALUES ('USER');
-- INSERT INTO 권한 (authority_name) VALUES ('INSTRUCTOR');

-- 게시판

-- 공지사항
--INSERT INTO 공지사항 (title, content, created_date)
--VALUES
--    ('긴급 휴강 안내', '강사님의 사정으로 인해 2025.01.01은 휴강으로 조정 되었습니다.', NOW()),
--    ('새해맞이 이벤트 안내', '새해를 맞아 학업에 지친 수강생님들을 위해 조식 떡국 제공 이벤트를 진행 합니다.',NOW());

 --과목
INSERT INTO 과목 (title, explanation, price, instructor_name)
VALUES('1종 자동.1종 수동 면허','')


-- 사용자
INSERT INTO 사용자 (user_name, password, email, real_name, user_birthdate, user_authority, createdAt, point)
VALUES
    ('pengsoo', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'pengsoo@email.com', '백병열' , '1999-09-09', 'ADMIN', NOW(), '10000');
    ('totoro', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'totoro@email.com', '강준우',  '1999-05-24', 'USER', NOW(), '20000');
    ('fourbie', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'fourbie@email.com', '정길수', '1999-06-06', 'INSTRUCTOR', NOW(), '30000');

---- 자동차종류
--INSERT INTO 자동차종류 (name)
--VALUES
--('승용차'),
--('1톤화물차'),
--('대형버스'),
--('오토바이 125CC 이상고배기량');
--
---- 이미지
--INSERT INTO 이미지 (image_url)
--VALUES
--('car photo_url'),
--('motor cycle photo_url'),
--('bus photo_url');
--
---- 비디오
--INSERT INTO 비디오 (video_url,subject_video)
--VALUES
--('Study video_url(1종보통)'),
--('Study video_url(2종보통)'),
--('Study video_url(1종대형)'),
--('Study video_url(2종소형)');