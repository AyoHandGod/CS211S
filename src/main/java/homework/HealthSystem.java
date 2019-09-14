package homework;

public interface HealthSystem {

    public String getStatus();
    public boolean isAlive();

    public int getHealth();

    public void takeDamage(int damageAmount);

    public void receiveHealing(int healingAmount);

}
