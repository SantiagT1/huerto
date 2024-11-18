public abstract class Dispositivo implements Monitoreable {
    private boolean monitoreando;
    protected int contadorHoras;

    public Dispositivo() {
        this.monitoreando = false;
        this.contadorHoras = 0;
    }



    public void iniciarMonitoreo() {
        this.monitoreando = true;
        System.out.println("Monitoreo iniciado.");
    }



    public void detenerMonitoreo() {
        this.monitoreando = false;
        System.out.println("Monitoreo detenido.");
    }


    public void incrementarContador() {
        if (monitoreando) {
            this.contadorHoras++;
        }
    }


    public boolean estaMonitoreando() {
        return monitoreando;
    }


    public int getContadorHoras() {
        return contadorHoras;
    }



    public abstract void monitorear();
}
