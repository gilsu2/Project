-- 권한
INSERT INTO 권한 (authority_name) VALUES ('ADMIN');
INSERT INTO 권한 (authority_name) VALUES ('USER');
INSERT INTO 권한 (authority_name) VALUES ('INSTRUCTOR');

-- 게시판

-- 공지사항
INSERT INTO  (title, content, user_name, created_date, modified_date, is_active)
VALUES
    ('중요 공지: 사이트 점검 안내', '다음 주 일요일 오전 2시부터 6시까지 사이트 점검이 진행됩니다. 이용에 불편을 드려 죄송합니다.', 'admin', NOW(), NOW(), true),
    ('새로운 기능 추가 안내', '회원 정보 수정 기능이 추가되었습니다. 마이페이지에서 이용해주세요.', 'admin', NOW(), NOW(), true),
    ('이벤트 참여 안내', '새로운 이벤트가 시작되었습니다! 많은 참여 부탁드립니다. 자세한 내용은 이벤트 페이지에서 확인하세요.', 'admin', NOW(), NOW(), true),
    ('오늘 저녁 뭐 먹지?', '오늘 저녁 메뉴 추천 부탁드려요! 뭘 먹어야 할지 고민이네요.', 'steve12', NOW(), NOW(), true),
    ('주말에 뭐하고 놀지?', '주말에 뭐하고 놀지 좋은 곳 있으면 추천해주세요.', 'steve12', NOW(), NOW(), true);