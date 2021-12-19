$(document).ready(function() {
    $.get("http://localhost:8080/api/v1/consultations", function (data) {
        let html = '';
        $.each(data, function (i, item) {
            html += '<tr>' +
                        '<td>' + item.id + '</td>' +
                '        <td>' + item.title + '</td>' +
                '        <td>' + item.clientName + '</td>' +
                '        <td>' + item.txt + '</td>' +
                '   </tr>';
        });
        $('#table').append(html);
    });

    $("form").submit(function(event) {
        event.preventDefault();

        let consultation = {
            title: $("#title").val(),
            clientName: $("#clientName").val(),
            txt: $("#txt").val()
        }

        console.log(JSON.stringify(consultation))

        $.ajax({
            type: 'POST',
            contentType : 'application/json',
            url: 'http://localhost:8080/api/v1/consultations',
            data: JSON.stringify(consultation),
            success: function (newConsultation) {
                let html = '';
                html += '<tr>' +
                    '<td>' + newConsultation.id + '</td>' +
                    '        <td>' + newConsultation.title + '</td>' +
                    '        <td>' + newConsultation.clientName + '</td>' +
                    '        <td>' + newConsultation.txt + '</td>' +
                    '   </tr>';
                $('#table').append(html);
            },
            error: function () {
                alert('error saving consultation')
            }
        })
    });

    $("#delete-btn").click(function (event) {
        event.preventDefault();
        
        const id = $("#deleteId").val();

        console.log('id')
        console.log(id)

        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/api/v1/consultations/' + id,
            success: function () {
                location.reload()
            },
            error: function () {
                alert('error deleting consultation')
            }
        })
    })
});