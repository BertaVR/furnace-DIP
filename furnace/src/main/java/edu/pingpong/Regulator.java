package edu.pingpong;

public class Regulator {
    public void regulate(Thermometer thermometer, Heater heater, double minTemp, double maxTemp, RoomTemperature temperature) {
        RegulatorDisplayCodes code;

        while (thermometer.read(temperature) < maxTemp) {
            code = RegulatorDisplayCodes.HEATING;
            heater.engage(temperature);
            message(code, temperature);
        }
        while (thermometer.read(temperature) > minTemp) {
            code = RegulatorDisplayCodes.WAITING;
            heater.disengage(temperature);
            message(code, temperature);
        }
    }

    private void message(RegulatorDisplayCodes code, RoomTemperature temperature) {
        switch (code) {
            case HEATING:
                System.out.println("Calentando => temperatura " + temperature.getTemperature());
                break;
            case WAITING:
                System.out.println("Apagado => temperatura " + temperature.getTemperature());
                break;
            default:
                System.out.println("Algo raro sucede...");
                break;
        }
    }
}
