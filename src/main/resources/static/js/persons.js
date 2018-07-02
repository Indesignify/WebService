$(document).ready(function () {

    var currentUrl = window.location;

    $("#createPersonBtnId").click(function (event) {
        event.preventDefault();
        ajaxPostPerson();
    });

    function ajaxPostPerson() {

        var formData = {
            id: $("#id").val(),
            lastName: $("#lastName").val(),
            firstName: $("#firstName").val(),
            middleName: $("#middleName").val(),
            birthDate: $("#birthDate").val()
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: currentUrl + "rest-api/person/",
            data: JSON.stringify(formData),
            success: function (result) {
                $("#postResultDiv").html(
                    "<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                    "Post was successful! Person's Info: ID = " + formData.id + " , " +
                    "lastName = " + formData.lastName + " , " +
                    "name = " + formData.firstName + " , " +
                    "middleName = " + formData.middleName + " , " +
                    "dateOfBirth = " + formData.birthDate
                );
            },
            error: function (result) {
                $("#postResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Error! Please read logs for more information."
                );
            }
        });
    }

    $("#getPersonByIdBtnId").click(function (event) {
        event.preventDefault();
        ajaxGetPersonById();
    });

    function ajaxGetPersonById() {
        $.ajax({
            type: 'GET',
            url: currentUrl + "rest-api/person/" + $("#id").val(),
            datatype: "json",
            success: function (result) {
                $("#getResultDiv").html(
                    "<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                    "Get person results: person with id = " + $("#id").val() +
                    ", lastName = " + result.lastName + ", firstName = " + result.firstName +
                    ", middleName = " + result.middleName + ", birthDate = " + result.birthDate +
                    ", comment = " + result.comment + ", updateDate = " + result.updateDate
                )
            },
            error: function (result) {
                $("#getResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Error! Read logs for more information."
                );
            }
        })
    }

    $("#updatePersonBtnId").click(function (event) {
        event.preventDefault();
        ajaxUpdatePerson();
    });

    function ajaxUpdatePerson() {

        var formData = {
            id: $("#id").val(),
            lastName: $("#lastName").val(),
            firstName: $("#firstName").val(),
            middleName: $("#middleName").val(),
            birthDate: $("#birthDate").val()
        }

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: currentUrl + "rest-api/person/" + $("#id").val(),
            dataType: "json",
            data: JSON.stringify(formData),
            success: function (data) {
                $("#postResultDiv").html(
                    "<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                    "Updated person successfully! New person's info: ID = " + formData.id + " , " +
                    "lastName = " + formData.lastName + " , " +
                    "name = " + formData.firstName + " , " +
                    "middleName = " + formData.middleName + " , " +
                    "dateOfBirth = " + formData.birthDate
                );
            },
            error: function () {
                $("#postResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Something went wrong! Please read logs for more information."
                );
            }
        });
    }

    $("#deletePersonBtnId").click(function (event) {
        event.preventDefault();
        ajaxDeletePerson();
    });

    function ajaxDeletePerson() {
        $.ajax({
            type: 'DELETE',
            url: currentUrl + "rest-api/person/" + $("#id").val(),
            success: function () {
                $("#deleteResultDiv").html(
                    "<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                    "Delete person results: person with id = " + $("#id").val() +
                    " was successfully deleted!"
                );
            },
            error: function () {
                $("#deleteResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Something went wrong! Please read logs for more information."
                );
            }
        });
    }


    $("#getAllPersonsBtnId").click(function (event) {
        event.preventDefault();
        ajaxGetAllPersons();
    });

    function ajaxGetAllPersons() {
        $.ajax({
            type: "GET",
            url: currentUrl + "rest-api/get-all",
            success: function (result) {
                $.each(result, function (i, person) {

                    var personRow = '<tr>' +
                        '<td><input type="radio"' + 'id="' + person.id + '"></td>' +
                        '<td>' + person.id + '</td>' +
                        '<td>' + person.lastName + '</td>' +
                        '<td>' + person.firstName + '</td>' +
                        '<td>' + person.middleName + '</td>' +
                        '<td>' + person.birthDate + '</td>' +
                        '<td>' + person.comment + '</td>' +
                        '<td>' + person.updateDate + '</td>' +
                        '</tr>';

                    $('#personsTable tbody').append(personRow);

                });
            },
            error: function (e) {
                $("#getResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Something went wrong! Read logs for more information."
                );
            }
        });
    }

    $("#handlePersonsBtnId").click(function (event) {
        event.preventDefault();
        ajaxHandleSelectedPersons();
    });

    function ajaxHandleSelectedPersons() {

        var persons = []

        $('input[type=radio]:checked').each(function() {
            persons.push($(this).attr('id'));
        });

        var formData = {
            personsIDs: persons.map(Number)
        }

        console.log(JSON.stringify(formData));

        $.ajax({
            type: "POST",
            contentType: 'application/json',
            url: currentUrl + "rest-api/handle",
            dataType: "json",
            data: JSON.stringify(formData),
            success: function (result) {
                $.each(result, function (i, person) {
                    $("#handleResultDiv").append($("#handleResultDiv").html(
                        "Handle results: id = " + person.id + ", comment = " + person.comment + ", updateDate = " + person.updateDate +
                        " <br/>"
                    ))
                });
            },
            error: function(result) {
                $("#handleResultDiv").html(
                    "<p style='background-color:red; color:white; padding:20px 20px 20px 20px'>" +
                    "Something went wrong!"
                )
            }
        })
    }
})