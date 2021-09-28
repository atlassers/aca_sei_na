class Room {
    constructor() { }

static load () {

    /*
    RoomService.getTotals();

    $('#wtfOne').click(function () {
      CourierService.getAmazon();
    });

    $('#wtfTwo').click(function () {
      CourierService.getCouriersByMonth();
    });
    */

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

        var id = document.getElementById('roomId').value;
        var denomination = document.getElementById('denomination').value;
        var tax_code = document.getElementById('seats').value;

        var formData = JSON.stringify({
          'denomination': denomination,
          'seats': seats
        });

        var formDataId = JSON.stringify({
          'roomId': id,
          'denomination': denomination,
          'seats': tax_code
        });

        if (id) {
          RoomService.put(formDataId);
        } else {
          RoomService.post(formData);
        }
    });
}
}