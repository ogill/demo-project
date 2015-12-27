$(document).ready(function() {
	$('#submit').click(function() {
		//alert("hello, again and again and again!!!!!");


        var url = "/services/all-sample" ;

        $.ajax(url, {
            dataType: "text",
            success: function(rawData, status, xhr) {
                var serverResponse;
                try {
                    serverResponse = $.parseJSON(rawData);

                    alert(serverResponse); 
                    alert("rawData is "+rawData);


                } catch(err) {
                    failure(err);
                }
            },
            error: function(xhr, status, err) {
                failure(err);
            } 
        });

    });

}); // end ready