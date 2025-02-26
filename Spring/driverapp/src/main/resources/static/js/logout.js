
    window.onload = function() {
        const user = sessionStorage.getItem("user");
        const loginLink = document.querySelector("#loginLink");
        const logoutLink = document.querySelector("#logoutLink");

        if (user) {
            loginLink.style.display = "none";
            logoutLink.style.display = "inline-block";
        } else {
            loginLink.style.display = "inline-block";
            logoutLink.style.display = "none";
        }
    }


    function logout() {
    $.ajax({
        url: '/api/user/logout',
        type: 'POST',
        success: function(response) {
            console.log('로그아웃 성공:', response);
            sessionStorage.removeItem("user");
            document.querySelector("#loginLink").style.display = "inline-block";
            document.querySelector("#logoutLink").style.display = "none";
        },
        error: function(xhr, status, error) {
            console.error('로그아웃 실패:', error);
        }
    });
}
