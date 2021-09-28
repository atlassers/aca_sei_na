class ClientService {
    constructor() { }


    static getAll() {
        BaseService.getAll('/clients/v1')
            .then(function (roomDtoList) {
                var content = '<table class="aca-fill">';
                content += '<tr>'
                    + '<th scope="col">Id</th>'
                    + '<th scope="col">Name</th>'
                    + '<th scope="col">Surname</th>'
                    + '<th scope="col">Birthdate</th>'
                    + '<th scope="col">Subscription</th>'
                    + '<th scope="col">Delete Btn</th>'
                    + '<th scope="col">Detail Btn</th>'
                    + '</tr>';
                jQuery.each(roomDtoList, function (i, val) {
                    content += '<tr>'
                        + '<td>' + val.idDto + '</td>'
                        + '<td>' + val.clientNameDto + '</td>'
                        + '<td>' + val.clientSurnameDto + '</td>'
                        + '<td>' + val.clientBirthDateDto + '</td>'
                        + '<td>' + val.subscribedDto + '</td>'
                        + '<td><button id="btnDelete-' + val.idDto + '" class="btn btn-danger" onclick="RoomService.delete(' + val.idDto + ')">delete</button></td>'
                        + '<td><button id="btnDetail-' + val.idDto + '" class="btn btn-warning" onclick="RoomService.detail(' + val.idDto + ')">detail</button></td>'
                        + '</tr>';
                });
                content += '</table>';

                $('#saveForm').trigger('reset');
                $('#saveForm').hide();
                $('#clientsTable').empty();
                $('#clientsTable').append(content);
                $('#clientsTable').show();
            });
    }

    static post(formData) {
        BaseService.post(ClientService.path, formData)
            .then(function (clientDto) {
                window.alert("New Client Added")
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                ClientService.getAll();
            });
    }

    static put(formDataId) {
        BaseService.put(RoomService.path, formDataId)
            .then(function (roomDto) {
                window.alert("Room Updated")
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                RoomService.getAll();
            });
    }

    static delete(id) {
        BaseService.delete(RoomService.path, id)
            .then(function (result) {
                window.alert('Room ' + id + ' successfully deleted!')

                RoomService.getAll();
            });
    }

    static detail(id) {
            BaseService.get('/rooms/v1', id)
                .then(function (roomDto) {
                    document.getElementById('idDto').value = roomDto.idDto;
                    document.getElementById('denomination').value = roomDto.roomDenomDto;
                    document.getElementById('seats').value = roomDto.numberOfSeatsDto;

                    $('#roomsTable').empty();
                    $('#roomsTable').hide();
                    $('#saveForm').show();
                });
        }
}

RoomService.path = '/clients/v1';



