import java.util.ArrayList;

public class Huerto implements Monitoreable {
    private Sensor sensor;
    private ArrayList<Integer> registroHumedadTierra;
    private ArrayList<Integer> registroNivelAgua;
    private ArrayList<Integer> registroTemperatura;
    private ArrayList<Integer> registroNutrientes;
    private boolean monitoreando;

    public Huerto() {
        this.sensor = new Sensor();
        this.registroHumedadTierra = new ArrayList<>();
        this.registroNivelAgua = new ArrayList<>();
        this.registroTemperatura = new ArrayList<>();
        this.registroNutrientes = new ArrayList<>();
        this.monitoreando = false;
    }


    public void iniciarMonitoreo() {
        this.monitoreando = true;
        System.out.println("Monitoreo iniciado.");
    }


    public void detenerMonitoreo() {
        this.monitoreando = false;
        System.out.println("Monitoreo detenido.");
    }


    public void monitorear() {
        if (monitoreando) {
            sensor.actualizarDatos();
            registroHumedadTierra.add(sensor.getHumedadTierra());
            registroNivelAgua.add(sensor.getNivelAgua());
            registroTemperatura.add(sensor.getTemperatura());
            registroNutrientes.add(sensor.getNivelNutrientes());


            mostrarRecomendaciones();
        }
    }


    public void mostrarDatos() {

        sensor.mostrarInformacion();
    }

    private void mostrarRecomendaciones() {
        double humedadTierra = sensor.getHumedadTierra();
        double nivelAgua = sensor.getNivelAgua();
        double temperatura = sensor.getTemperatura();
        double nutrientes = sensor.getNivelNutrientes();

        System.out.println("\nRecomendaciones:");


        if (humedadTierra < 40) {
            System.out.println("- La humedad de la tierra es baja (" + humedadTierra + "%). Se recomienda regar el huerto.");
        } else if (humedadTierra > 70) {
            System.out.println("- La humedad de la tierra es alta (" + humedadTierra + "%). Evita el riego excesivo.");
        }


        if (nivelAgua < 50) {
            System.out.println("- El nivel de agua es bajo (" + nivelAgua + "%). Asegúrate de que el sistema de riego esté funcionando correctamente.");
        }


        if (temperatura > 35) {
            System.out.println("- La temperatura es alta (" + temperatura + "°C). Considera proporcionar sombra o sistemas de enfriamiento.");
        } else if (temperatura < 10) {
            System.out.println("- La temperatura es baja (" + temperatura + "°C). Considera sistemas de calefacción para proteger las plantas.");
        }


        if (nutrientes < 40) {
            System.out.println("- El nivel de nutrientes es bajo (" + nutrientes + "%). Añadir fertilizante puede mejorar la calidad del suelo.");
        }
    }

    private double calcularPromedio(ArrayList<Integer> registros) {
        int suma = 0;
        for (int valor : registros) {
            suma += valor;
        }
        return (double) suma / registros.size();
    }

    public void mostrarMediasYConsejos() {
        double mediaHumedadTierra = calcularPromedio(registroHumedadTierra);
        double mediaNivelAgua = calcularPromedio(registroNivelAgua);
        double mediaTemperatura = calcularPromedio(registroTemperatura);
        double mediaNutrientes = calcularPromedio(registroNutrientes);

        System.out.println("\nResumen de los últimos 3 días:");
        System.out.printf("Media de Humedad de Tierra: %.2f%%\n", mediaHumedadTierra);
        System.out.printf("Media de Nivel de Agua: %.2f%%\n", mediaNivelAgua);
        System.out.printf("Media de Temperatura: %.2f°C\n", mediaTemperatura);
        System.out.printf("Media de Nivel de Nutrientes: %.2f%%\n", mediaNutrientes);


        System.out.println("\nRecomendaciones generales:");
        if (mediaHumedadTierra < 40) {
            System.out.println("- La humedad de la tierra es baja. Se recomienda regar el huerto más frecuentemente.");
        } else if (mediaHumedadTierra > 70) {
            System.out.println("- La humedad de la tierra es alta. Evita el riego excesivo para prevenir el encharcamiento.");
        }

        if (mediaNivelAgua < 50) {
            System.out.println("- El nivel de agua es bajo. Asegúrate de que el sistema de riego esté funcionando correctamente.");
        }

        if (mediaTemperatura > 35) {
            System.out.println("- La temperatura es alta. Considera proporcionar sombra o sistemas de enfriamiento.");
        } else if (mediaTemperatura < 10) {
            System.out.println("- La temperatura es baja. Considera sistemas de calefacción para proteger las plantas.");
        }

        if (mediaNutrientes < 40) {
            System.out.println("- El nivel de nutrientes es bajo. Añadir fertilizante puede mejorar la calidad del suelo.");
        }
    }
}
