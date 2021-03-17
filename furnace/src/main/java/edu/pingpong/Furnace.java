package edu.pingpong;

public class Furnace
{
    public static void main( String[] args )
    {
        final double minTemp = 15.0;
        final double maxTemp = 21.0;

        RoomTemperature temperature = new RoomTemperature(15);
        Heater heater = new GasHeater();
        Thermometer thermometer = new RemoteCommandSensor();

        Regulator regulator = new Regulator();

        System.out.println( "Arrancando..." );
        regulator.regulate(thermometer, heater, minTemp, maxTemp, temperature);

        Heater yoda = new Jedi(); //Lo he cambiado de clase Jedi a interfaz Heater para probar el casting
        System.out.println( "\nArrancando a Yoda: " );
        regulator.regulate(thermometer, yoda, minTemp, maxTemp, temperature);
        ((Jedi)yoda).speak(); //Este es el casting, si no pasas yoda a Heater no puedes llamar al método speak
    }
}