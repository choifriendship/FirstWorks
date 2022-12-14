var eventModal = $('#eventModal');

var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editDept = $('#edit-dept');
var editColor = $('#edit-color');
var editTxt = $('#edit-txt');

var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');


/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('일정 추가');
    editType.val(eventType).prop('selected', true);
    editTitle.val('');
    editStart.val(start);
    editEnd.val(end);
    editTxt.val('');
    
    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    //새로운 일정 저장버튼 클릭
    $('#insertEvent').unbind();
    $('#insertEvent').on('click', function () {
	
        var eventData = {
            //id: eventId,
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
            txt: editTxt.val(),
            type: editType.val(),
            dept_no: editDept.val(),
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: editAllDay.val()
        };

        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
            return false;
        }
        
        if (eventData.txt === '') {
            alert('일정내용은 필수입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            //render시 날짜표기수정
            //eventData.end = moment(eventData.end).add(1, 'days').format('YYYY-MM-DD');
            eventData.end = moment(eventData.end).format('YYYY-MM-DD');
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');

        //새로운 일정 저장
        $.ajax({
            type: "post",
            url: "calendarInsert",
            data: eventData,
            success: function (response) {
            
                //DB연동시 중복이벤트 방지
                $('#calendar').fullCalendar('removeEvents');
                $('#calendar').fullCalendar('refetchEvents');
                
            }
        });
    });
};