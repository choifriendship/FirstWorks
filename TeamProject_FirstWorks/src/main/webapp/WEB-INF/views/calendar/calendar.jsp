<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
	<!-- 풀캘린더 시작 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/calendar/vendor/css/fullcalendar.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/calendar/vendor/css/bootstrap.min.css?ver=2">
    <link rel="stylesheet" href='${pageContext.request.contextPath}/resources/calendar/vendor/css/select2.min.css' />
    <link rel="stylesheet" href='${pageContext.request.contextPath}/resources/calendar/vendor/css/bootstrap-datetimepicker.min.css' />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/calendar/css/main.css">
	<!-- 풀캘린더 끝 -->
   
</head>
<body>
      <!-- begin #content -->
      <div id="content" class="content">
       <!-- 일자 클릭시 메뉴오픈 -->
        <div id="contextMenu" class="dropdown clearfix">
            <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
                style="display:block;position:static;margin-bottom:5px;">
                <li><a tabindex="-1" href="#">내부일정</a></li>
                <li><a tabindex="-1" href="#">외부일정</a></li>
                <li><a tabindex="-1" href="#">개인일정</a></li>
                <li><a tabindex="-1" href="#">기타</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
            </ul>
        </div>

        <div id="wrapper">
            <div id="loading"></div>
            <div id="calendar"></div>
        </div>

        <!-- 일정 추가 MODAL -->
        <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body">

                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-allDay">하루종일</label>
                                <input class='allDayNewEvent' id="edit-allDay" type="checkbox" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-title">일정명</label>
                                <input class="inputModal" type="text" name="edit-title" id="edit-title"
                                    required="required" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-start">시작</label>
                                <input class="inputModal" type="text" name="edit-start" id="edit-start" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-end">끝</label>
                                <input class="inputModal" type="text" name="edit-end" id="edit-end" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-type">구분</label>
                                <select class="inputModal" type="text" name="edit-type" id="edit-type">
                                    <option value="내부일정">내부일정</option>
                                    <option value="외부일정">외부일정</option>
                                    <option value="개인일정">개인일정</option>
                                    <option value="기타">기타</option>
                                </select>
                            </div>
                        </div>
                         <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-dept">관련 부서</label>
                                <select class="inputModal" type="text" name="edit-dept" id="edit-dept">
                                    <option value="개발팀">개발팀</option>
                                    <option value="인사팀">인사팀</option>
                                    <option value="기획팀">기획팀</option>
                                    <option value="디자인팀">디자인팀</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-color">색상</label>
                                <select class="inputModal" name="color" id="edit-color">
                                    <option value="#D25565" style="color:#D25565;">빨간색</option>
                                    <option value="#9775fa" style="color:#9775fa;">보라색</option>
                                    <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
                                    <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
                                    <option value="#f06595" style="color:#f06595;">핑크색</option>
                                    <option value="#63e6be" style="color:#63e6be;">연두색</option>
                                    <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
                                    <option value="#4d638c" style="color:#4d638c;">남색</option>
                                    <option value="#495057" style="color:#495057;">검정색</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-txt">설명</label>
                                <textarea rows="4" cols="50" class="inputModal" name="edit-txt"
                                    id="edit-txt"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer modalBtnContainer-addEvent">
                        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" id="insertEvent">저장</button>
                    </div>
                    <div class="modal-footer modalBtnContainer-modifyEvent">
                        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
                        <button type="button" class="btn btn-primary" id="updateEvent">저장</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <div class="panel panel-default">

            <div class="panel-heading">
                <h3 class="panel-title">필터</h3>
            </div>

            <div class="panel-body">

                <div class="col-lg-6">
                    <label for="calendar_view">분류별</label>
                    <div class="input-group">
                        <select class="filter" id="type_filter" multiple="multiple">
                            <option value="내부일정">내부일정</option>
                            <option value="외부일정">외부일정</option>
                            <option value="개인일정">개인일정</option>
                            <option value="기타">기타</option>
                        </select>
                    </div>
                </div>

                <div class="col-lg-6">
                    <label for="calendar_view">부서별</label>
                    <div class="input-group">
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="개발팀"
                                checked>개발팀</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="인사팀"
                                checked>인사팀</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="기획팀"
                                checked>기획팀</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="디자인팀"
                                checked>디자인팀</label>
                    </div>
                </div>

            </div>
        </div>
        <!-- /.filter panel -->
   	</div>
      <!-- end #content -->
   
	<!-- 풀캘린더 js 시작 -->
	<script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/fullcalendar.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/ko.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/vendor/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/js/main.js?ver=3"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/js/addEvent.js?ver=3"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/js/editEvent.js?ver=3"></script>
    <script src="${pageContext.request.contextPath}/resources/calendar/js/etcSetting.js?ver=3"></script>
    
</body>
</html>