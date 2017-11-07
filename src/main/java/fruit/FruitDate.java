package fruit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

public class FruitDate {
    private Date dateReceived;
    private Date dateSpoiled;

    public FruitDate ( Fruit fruit ) throws ParseException {
        this.dateReceived = new SimpleDateFormat ( "dd/MM/yyyy" ).parse ( fruit.getDate ( ) );
        Calendar calendar = Calendar.getInstance ( );
        calendar.setTime ( dateReceived );
        calendar.add ( Calendar.DATE , fruit.getShelfTime ( ) );
        this.dateSpoiled = calendar.getTime ( );

    }

    public Date getDateReceived ( ) {
        return dateReceived;
    }

    public Date getDateSpoiled ( ) {
        return dateSpoiled;
    }

    public Date getSimpleDate ( String date ) throws ParseException {
        return new SimpleDateFormat ( "dd/MM/yyyy" ).parse ( date );
    }
}
