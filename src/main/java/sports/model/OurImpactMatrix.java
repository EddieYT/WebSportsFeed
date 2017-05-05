package sports.model;

/**
 * This class implements ImpactMatrix with a customized weighting formula.
 * Created by Eddie on 5/4/17.
 */
public class OurImpactMatrix implements ImpactMatrix{
    private double pointsFactor;
    private double assistsFactor;
    private double reboundsFactor;
    private double stealsFactor;
    private double blocksFactor;

    /**
     * Constructor for OurImpactMatrix
     * @param pointsFactor
     * @param assistsFactor
     * @param reboundsFactor
     * @param stealsFactor
     * @param blocksFactor
     */
    public OurImpactMatrix(double pointsFactor, double assistsFactor, double reboundsFactor, double stealsFactor, double blocksFactor) {
        this.pointsFactor = pointsFactor;
        this.assistsFactor = assistsFactor;
        this.reboundsFactor = reboundsFactor;
        this.stealsFactor = stealsFactor;
        this.blocksFactor = blocksFactor;
    }

    @Override
    public double countImpact(NbaPlayer player) {
        double impact = Double.parseDouble(player.getAvgPoint())*pointsFactor +
                Double.parseDouble(player.getAvgAssist())*assistsFactor +
                Double.parseDouble(player.getAvgRebound())*reboundsFactor +
                Double.parseDouble(player.getAvgSteal())*stealsFactor +
                Double.parseDouble(player.getAvgBlock())*blocksFactor;
        return impact;
    }
}
