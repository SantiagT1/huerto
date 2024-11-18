import java.util.Random;

public class Sensor {
    private int humedadTierra;
    private int nivelAgua;
    private int temperatura;
    private int nivelNutrientes;

    public Sensor() {
        actualizarDatos();
    }

    public void actualizarDatos() {
        Random random = new Random();
        this.humedadTierra = random.nextInt(100);
        this.nivelAgua = random.nextInt(100);
        this.temperatura = random.nextInt(35) + 5;
        this.nivelNutrientes = random.nextInt(100);
    }

    public int getHumedadTierra() {
        return humedadTierra;
    }

    public int getNivelAgua() {
        return nivelAgua;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getNivelNutrientes() {
        return nivelNutrientes;
    }

    public void mostrarInformacion() {
        System.out.println("Humedad de la Tierra: " + humedadTierra + "%");
        System.out.println("Nivel de Agua: " + nivelAgua + "%");
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Nivel de Nutrientes: " + nivelNutrientes + "%");
    }
}

