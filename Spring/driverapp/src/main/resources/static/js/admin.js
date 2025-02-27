


function move() {
    const role = sessionStorage.getItem('authority');  // 'ADMIN' 또는 'USER' 값

    if (!role) {
        // 만약 authority 값이 없으면 로그인 페이지로 이동
        alert("로그인 정보가 없습니다. 로그인 페이지로 이동합니다.");
        window.location.href = "login.html";
        return;
    }

    // authority 값을 비교해서 이동할 페이지를 결정
    if (role === "ADMIN") {
        // 관리자는 관리자 페이지로 이동
        window.location.href = "adminpage.html";
    } else if (role === "USER") {
        // 일반 유저는 유저 마이페이지로 이동
        window.location.href = "usermypage.html";
    } else {
        // 예상치 못한 값이면 로그인 페이지로 이동
        alert("로그인 정보가 잘못되었습니다.");
        window.location.href = "login.html";
    }
}