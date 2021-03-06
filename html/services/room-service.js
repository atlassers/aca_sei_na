class RoomService {
    constructor() { }


    static getAll() {
        BaseService.getAll('/rooms/v1')
            .then(function (roomDtoList) {
                var content = '<table class="aca-fill">';
                content += '<tr>'
                    + '<th scope="col">Id</th>'
                    + '<th scope="col">Denomination</th>'
                    + '<th scope="col">Seats</th>'
                    + '<th scope="col">3DProjector</th>'
                    + '<th scope="col">Delete Btn</th>'
                    + '<th scope="col">Detail Btn</th>'
                    + '</tr>';
                jQuery.each(roomDtoList, function (i, val) {
                    content += '<tr>'
                        + '<td>' + val.idDto + '</td>'
                        + '<td>' + val.roomDenomDto + '</td>'
                        + '<td>' + val.numberOfSeatsDto + '</td>'
                        + '<td>' + val.hasA3DProjectorDto + '</td>'
                        + '<td><button id="btnDelete-' + val.idDto + '" class="btn btn-danger" onclick="RoomService.delete(' + val.idDto + ')">delete</button></td>'
                        + '<td><button id="btnDetail-' + val.idDto + '" class="btn btn-warning" onclick="RoomService.detail(' + val.idDto + ')">detail</button></td>'
                        + '</tr>';
                });
                content += '</table>';

                $('#saveForm').trigger('reset');
                $('#saveForm').hide();
                $('#roomsTable').empty();
                $('#roomsTable').append(content);
                $('#roomsTable').show();
            });
    }

    static post(formData) {
        BaseService.post(RoomService.path, formData)
            .then(function (roomDto) {
                window.alert("New Room Added")
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                RoomService.getAll();
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

RoomService.path = '/rooms/v1';



