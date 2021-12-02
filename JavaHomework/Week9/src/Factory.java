import java.util.Random;

public class Factory {
    static Random random = new Random();

    public static void main(String[] args) {
        machineStats(3);
        heatManagerStats(10);
    }

    public static void machineStats(int numberOfMachinesYouWantToHave){
        Machine [] machines = new Machine[numberOfMachinesYouWantToHave];
        creatingMachines(machines);

        int count = 1;
        for (Machine mach: machines){
            System.out.println("Machine №" + count + " with color-"
                        + mach.getColor() + " has power of: " + mach.getPower());
            count++;
        }
    }

    public static Machine[] creatingMachines(Machine[] machines){
        String[] colors = new String[]{"Red", "Blue", "Green", "Yellow", "Grey",
        "Black", "Brown"};

        for(int i = 0; i < machines.length; i++){
            machines[i] = new Machine();
            machines[i].setPower(random.nextInt(100) + 1);
            machines[i].setHeight(random.nextInt(5) + 1);
            machines[i].setColor(colors[random.nextInt(colors.length)]);
        }

        return machines;
    }

    public static void heatManagerStats(int numberOfElementsInTheHeatManager){
        HeatManager heatManager = new HeatManager(numberOfElementsInTheHeatManager);

        for(int i = 0; i <= numberOfElementsInTheHeatManager/2; i++){
            HeatEngine heatEngine = new HeatEngine();
            heatEngine.setPower(random.nextInt(100) + 1);
            heatManager.addElement(heatEngine);
        }

        for(int i = numberOfElementsInTheHeatManager - 1; i > numberOfElementsInTheHeatManager/2; i--){
            WrapperEngine wrapperEngine = new WrapperEngine();
            wrapperEngine.setPower(random.nextInt(100) + 1);
            heatManager.addElement(wrapperEngine);
        }

        System.out.println("The highest temperature in the heatManager array is: "
                + heatManager.returningTheHighestTemperature());
    }
}
