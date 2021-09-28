class RoomService {
    constructor() { }

/*
    static getTotals() {
        BaseService.getAll(CourierService.path + "/total/{number}").then(function(couriersTotal){
            $("#totalCouriers").text(couriersTotal);
        });

        BaseService.getAll(CourierService.path + "/total/valid/{number}").then(function(couriersValidTotal){
            $("#totalCouriersValid").text(couriersValidTotal);
        });

        BaseService.getAll(CourierService.path + "/total/invalid/{number}").then(function(couriersNotValidTotal){
            $("#totalCouriersNotValid").text(couriersNotValidTotal);
        });
    }


    static getAmazon() {
      BaseService.getAll(CourierService.path + '/WTFOne')
        .then(function(amazonList){

          var content = '<table>';
          content += '<tr>'
            + '<th scope="col">Denomination</th>'
            + '<th scope="col">Count</th>'
            + '</tr>';
            jQuery.each(amazonList, function (i, val) {
              content += '<tr>'
                + '<td>' + val.courierDenomination + '</td>'
                + '<td>' + val.courierCount + '</td>'
                + '</tr>';
            });

            content += '</table>';

            $('#tableWTFOne').empty();
            $('#tableWTFOne').append(content);
            $('#tableWTFOne').show();
      });
    }

    static getCouriersByMonth() {
          BaseService.getAll(CourierService.path + '/WTFTwo')
            .then(function(couriersByMonthList){

              var content = '<table>';
              content += '<tr>'
                + '<th scope="col">Denomination</th>'
                + '<th scope="col">Month</th>'
                + '<th scope="col">Count</th>'
                + '</tr>';
                jQuery.each(couriersByMonthList, function (i, val) {
                  content += '<tr>'
                    + '<td>' + val.courierDenomination + '</td>'
                    + '<td>' + val.dmonth + '</td>'
                    + '<td>' + val.courierCount + '</td>'
                    + '</tr>';
                });

                content += '</table>';

                $('#tableWTFTwo').empty();
                $('#tableWTFTwo').append(content);
                $('#tableWTFTwo').show();
          });
        }
        */



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

                CourierService.getAll();
                CourierService.getTotals();
            });
    }

    static put(formDataId) {
        BaseService.put(RoomService.path, formDataId)
            .then(function (roomDto) {
                window.alert("Room Updated")
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                RoomService.getAll();
                RoomService.getTotals();
            });
    }

    static delete(id) {
        BaseService.delete(RoomService.path, id)
            .then(function (result) {
                window.alert('Room ' + id + ' successfully deleted!')

                RoomService.getAll();
                //RoomService.getTotals();
            });
    }

    static detail(id) {
            BaseService.get('/rooms/v1', id)
                .then(function (roomDto) {
                    document.getElementById('roomId').value = roomDto.idDto;
                    document.getElementById('denomination').value = roomDto.roomDenomDto;
                    document.getElementById('seats').value = roomDto.numberOfSeatsDto;

                    $('#roomsTable').empty();
                    $('#roomsTable').hide();
                    $('#saveForm').show();
                });
        }
}

RoomService.path = '/rooms/v1';



