public class Main {
    public static void main(String[] args) {
        Huerto huerto = new Huerto();

        System.out.println("Iniciando monitoreo del huerto cada 5 horas durante 3 días...\n");
        int horasTotales = 72;

        huerto.iniciarMonitoreo();

        for (int hora = 0; hora < horasTotales; hora += 5) {
            System.out.println("Hora: " + (hora % 24) + ":00 del día " + (hora / 24 + 1));
            huerto.monitorear();
            huerto.mostrarDatos();
            System.out.println();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        huerto.mostrarMediasYConsejos();
        huerto.detenerMonitoreo();
    }
}
