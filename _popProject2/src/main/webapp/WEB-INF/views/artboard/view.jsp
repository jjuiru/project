<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOHAJIPOP!</title>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">--%>
    <link rel="stylesheet" type="text/css" href="root/css/reset.css">
    <link rel="stylesheet" type="text/css" href="root/css/common.css">
    <link rel="stylesheet" type="text/css" href="root/css/sub_popup_li_01.css">
    <script src="root/js/common.js"></script>
    <script src="root/js/sub_popup_li.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=2ko63nwjlc&submodules=geocoder"></script>
<style>
    .heart-btn {
        cursor: pointer;
        color: black; /* 기본적으로 검정으로 설정 */
    }
    .heart-btn.active {
        color: red; /* 클릭되었을 때 빨간색으로 변경 */
    }
    </style>
</head>
<body>

<header>
    <div class="inner_wrap">
        <h1><a href="main">MOHAJIPOP!</a></h1>
        <button id="btn_menu"><span class="blind">menu button</span></button>
        <div class="utility">
            <c:choose>
                <c:when test="${loginC}">
                    <span>${userId}님.로그인</span>
                    <a href="myPage"><span>마이페이지</span></a>
                    <a href="logout"><span>로그아웃</span></a>
                </c:when>
                <c:otherwise>
                    <a href="loginPage"><span>로그인</span></a>
                    <a href="signUpPage"><span>회원가입</span></a>

                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <nav>
        <ul>
            <li><a href="selectAllList">POPUP</a></li>
            <li><a href="#">MAP</a></li>
            <li><a href="#">EVENT</a></li>
        </ul>
    </nav>
</header>

<section class="content">
    <h2 class="blind">Pop-up information title section</h2>
    <div class="inner_wrap_02">
        <a href="selectAllList" class="btn_return"><span><span class="blind">page return button</span></span></a>
        <div class="img_wrap">
            <img src="<c:url value='${pop.rink}' />" alt="콘텐츠 이미지">
        </div>
        <div class="info_wrap">
            <div class="sns_wrap">
                <a href="#"><span class="blind">X</span></a><!--
			 --><a href="#"><span class="blind">instagram</span></a><!--
			 --><a href="#"><span class="blind">facebook</span></a><!--
			 --><a href="#" role="button"><span class="blind">link copy</span></a>
            </div>
    <!-- 제목 -->
    <h3>${pop.popName}</h3>
            <p>${count}</p>
            <button class="heart-btn ${onOff == 'on' ? 'active' : ''}" onclick="toggleHeart(this, '${pop.popCode}')">
                <i class="far fa-heart"></i> <!-- 빈 하트 아이콘 -->
            </button>
            <div class="info_01">
                <p class="local">${pop.place}</p>
                <p class="when">${pop.startDay} - ${pop.endDay}</p>
            </div>
            <a onclick="scrollToBoardForm();" style="cursor: pointer;">review</a>
            <div class="info_02">
                <ul class="clearfix">
                    <li>
                        <div class="img_wrap">
                            <img src="root/images/ico_parking.png" alt="Parking available icon image">
                        </div>
                        <p>주차가능</p>
                    </li>
                    <li>
                        <div class="img_wrap">
                            <img src="root/images/ico_ticket.png" alt="An admission fee icon image">
                        </div>
                        <p>입장료 유료</p>
                    </li>
                    <li>
                        <div class="img_wrap">
                            <img src="root/images/ico_nodrink.png" alt="No food and drink allowed icon image">
                        </div>
                        <p>식음료 반입금지</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</section>
<section class="information">
    <h2 class="blind">POP-UP STORE information section</h2>
    <div class="inner_wrap_02">
        <div class="imgs_wrap">
            <img src="<c:url value='${pop.rink}' />" alt="TWS: POP-UP STORE poster image 01">
        </div>
        <div class="txt_wrap">
            <h3>${pop.popName}</h3>
            <div class="info_desc">
                <p>POP-UP STORE</p>
<%--                <p>TWS : THE MUSEUM VISITOR</p>--%>
                <p href="${pop.weblink}">${pop.weblink}</p>
            </div>
            <p class="desc">${pop.content}</p>
            <p class="desc_02">[Promotion]<br>- 의류 및 가방 구매 고객 대상 포토카드 1매를 랜덤 증정(상품 1개당 1매)<br>- 10만원 이상 구매고객 대상 포토부스 촬영 쿠폰을 증정(1인당 1매)<br>- 12만원 이상 구매고객 대상 포토카드세트 1set 증정(12만원 당 1세트)</p>
        </div>
    </div>
</section>

<section class="map">
    <div class="inner_wrap_02">
        <!-- 지도api -->
<%--<div id="map" style="width:40%;height:400px;"></div>--%>
        <div
                id="map"
                style="width:100%; height:450px; border:0;"
        ></div>
    </div>
</section>

<div id="showboard"></div>
<section class="review">
    <div class="inner_wrap_02">
        <h2>REVIEW</h2>
        <div class="average">
            <span class="active star"><span class="blind">star ico</span></span>
            <p>${val}</p>
        </div>

        <div class="review_list">
            <h3 class="blind">review list</h3>

            <ul>
                <c:forEach var="board" items="${popBoard}">
                    <li>
                        <div class="score">
                            <c:forEach begin="1" end="${board.star}">
                                <i class="active star"><span class="blind">star icon</span></i>
                            </c:forEach>
                        </div>
                        <div class="comment">
                            <p class="user_id">${board.userId}   ${board.content}</p>
<%--                            <p class="user_review">${board.content}</p>--%>
                        </div>
                        <div class="user_write_date">
                            <p>${board.regtime}</p>
                        </div>
                        <p hidden>${board.num}</p>
                        <p hidden>${board.popCode}</p>
                        <c:if test="${sessionScope.userId eq board.userId}">
                            <button onclick="window.location.href='/deletePopboard?num=${board.num}&popCode=${popCode}&page=${currentPage}'">삭제</button>
<%--                            <button>수정</button>--%>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>

            <c:set var="currentPage" value="${currentPage}" /> <!-- 현재 페이지 번호를 가져와 변수에 저장합니다. -->

            <c:if test="${totalPages > 0}">
                <c:if test="${currentPage > 0}">
                    <a href="view" onclick="getPage(${currentPage - 1})">이전</a>
                </c:if>

                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="/view?page=${i+1}&popCode=${popCode}">${i + 1}</a>
                </c:forEach>

                <c:if test="${currentPage < totalPages - 1}">
                    <a href="view" onclick="getPage(${currentPage + 1})">다음</a>
                </c:if>
            </c:if>
        </div>
        <div class="review_write">
            <div class="write_score">
                <h3>클릭해서 별점을 매겨주세요</h3>
<%--                <form action="/action_page.php" method="post">--%>
                    <form id="boardForm" action="insertPopboard?page=${currentPage}" method="post" onsubmit="return checkUserId()">
                        <input hidden type="text" id="num" name="num" >
                        <input hidden type="text" id="userId" name="userId" value="${userId}">
                        <input hidden type="text" id="popCode" name="popCode" value="${popCode}">
                    <div class="score_wrap">
                        <label for="star_1"><input type="radio" name="star" id="star_1" value="1" required><span class="ico_star"><span class="blind">star icon</span></span></label>
                        <label for="star_2"><input type="radio" name="star" id="star_2" value="2" required><span class="ico_star"><span class="blind">star icon</span></span></label>
                        <label for="star_3"><input type="radio" name="star" id="star_3" value="3" required><span class="ico_star"><span class="blind">star icon</span></span></label>
                        <label for="star_4"><input type="radio" name="star" id="star_4" value="4" required><span class="ico_star"><span class="blind">star icon</span></span></label>
                        <label for="star_5"><input type="radio" name="star" id="star_5" value="5" required><span class="ico_star"><span class="blind">star icon</span></span></label>
                    </div>
                        <input type="hidden" id="selectedStar" name="selectedStar">
                        <input type="hidden" id="star0" name="star">
                        <div class="review_title">
                            <label class="title">작성자</label><label type="text" id="user_id" name="userId" maxlength="255" autocomplete="off" required>${userId}</label>
                        </div>
                    <div class="review_desc">
                        <textarea name="content" placeholder="방문하신 팝업 스토어는 어떠셨나요? 후기를 통해 회원님의 경험을 다른 분들과 공유해보세요.&#13;&#10;해당 팝업스토어와 관련이 없는 내용 혹은 이미지를 업로드 하신 경우 별도의 통보없이 삭제 및 혜택이 회수됩니다."></textarea>
                    </div>
                    <button type="submit" value="등록하기">등록하기<span class="blind">submit button</span></button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Font Awesome 스크립트 CDN 링크 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
<script>
        var address = "${pop.place}";
        
        // 입력받은 주소로 좌표 변환 요청
        naver.maps.Service.geocode({ address: address }, function(status, response) {
            if (status === naver.maps.Service.Status.OK) {
                var coords = response.result.items[0].point;
                var mapOptions = {
                    center: new naver.maps.LatLng(coords.y, coords.x),
                    zoom: 17
                };

                // 지도를 생성하고 표시합니다.
                var map = new naver.maps.Map('map', mapOptions);
                
                // 지도에 마커를 추가합니다.
                var marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(coords.y, coords.x),
                    map: map
                });
            } else {
                alert('주소를 찾을 수 없습니다.');
            }
        });
    </script>
<script>
    const stars = document.querySelectorAll('input[name="star"]');

    stars.forEach((star) => {
        star.addEventListener('click', function() {
            document.getElementById('selectedStar').value = this.value;
        });
    });
</script>
<script>
//댓글등록시 실행되는 함수
function checkUserId() {
    var userId = document.getElementById('userId').value;
    if (userId === null || userId === '') {
        alert('로그인 후 이용해주세요.');
        return false; // 서브밋을 막습니다.
    }
    return true; // 폼을 제출합니다.
}
// 댓글을 클릭할 때 호출되는 함수
function fillForm(row) {
    // 클릭한 댓글의 각 셀에서 값을 가져옵니다.
    var clickedUserId = row.cells[1].innerText;
    var title = row.cells[2].innerText;
    var content = row.cells[3].innerText;
    var num = row.cells[5].innerText;
    var popCode = row.cells[6].innerText;

    // 폼에 가져온 값을 채워 넣습니다.
    document.getElementById("userId").value = clickedUserId;
    document.getElementById("content").value = content;
    document.getElementById("num").value = num;
    document.getElementById("popCode").value = popCode;
}

window.onload = function() {
    var textValue = "${text}";
    var showboard = "${save}"
    var showboardElement = document.getElementById("showboard");
    if (textValue === 'on') {
        alert('로그인 후 이용해 주세요.');
        window.location.href = '/loginPage';
    }

    if (showboard === 'on') {
        showboardElement.scrollIntoView(); // showboard 요소로 스크롤 이동
    }
};

function scrollToBoardForm() {
    var showboardElement = document.getElementById("showboard");
    if (showboardElement) {
        showboardElement.style.display = "block"; // showboard 요소를 화면에 표시합니다.
        showboardElement.scrollIntoView({ behavior: 'smooth' }); // showboard 요소로 스크롤 이동
    }
}
    function toggleHeart(button, popCode) {
    	var page ="${currentPage}";
        button.classList.toggle("active"); // 버튼에 active 클래스를 toggle하여 버튼의 색상을 변경합니다.
        
        // 버튼의 상태에 따라 리다이렉트
        if (button.classList.contains("active")) {
            // 버튼이 활성화된 상태일 때 (하트가 클릭된 상태)
           window.location.href = "like?status=on&popCode=" + popCode +"&page=" + page; // popCode 값을 파라미터로 추가합니다.
        } else {
            // 버튼이 비활성화된 상태일 때 (하트가 클릭되지 않은 상태)
             window.location.href = "like?status=off&popCode="  + popCode +"&page=" + page; // popCode 값을 파라미터로 추가합니다.           
        }
    }
</script>
</body>
</html>