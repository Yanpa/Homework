public class HeatManager {
    Engine [] engines;
    int indexOfElement = 0;

    public HeatManager(int sizeOfArray){
        this.engines = new Engine[sizeOfArray];
    }

    public void addElement(Engine addedElement){
        engines[indexOfElement] = addedElement;
        indexOfElement++;
    }

    public int returningTheHighestTemperature(){
        int maxTemperature = engines[0].getPower();
        for(int i = 1; i < engines.length; i++){
            if(maxTemperature < engines[i].getPower()) maxTemperature = engines[i].getPower();
        }
        return maxTemperature;
    }
}
