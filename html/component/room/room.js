class Room {
    constructor() { }

static load () {

    $('#btnShow').click(function () {
      RoomService.getAll();
    });

    $('#btnAdd').click(function () {
      $('.table').empty();
      $('.table').hide();
      $('#saveForm').show();
    });

    $('#saveForm').submit(function (event) {
        event.preventDefault();

        var id = document.getElementById('idDto').value;
        var denomination = document.getElementById('denomination').value;
        var seats = document.getElementById('seats').value;

        var formData = JSON.stringify({
          'roomDenomDto': denomination,
          'numberOfSeatsDto': seats
        });

        var formDataId = JSON.stringify({
          'idDto': id,
          'numberOfSeatsDto': denomination,
          'numberOfSeatsDto': seats
        });

        if (id) {
          RoomService.put(formDataId);
        } else {
          RoomService.post(formData);
        }
    });
}
}