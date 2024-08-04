package com.github.tecnomaster;

import com.github.tecnomaster.implementation.VerletGrid;

/**
 * The Solver is the heart of the simulation. It handles all the physics and ensures that the simulation is stepping correctly.
 * It allows to set sub steps who decide how many times the simulation is stepped between each step.
 * It also allows to set a {@link VerletGrid} which can drastically improve performance.
 * It requires a {@link VerletContainer} in order to run. If it gets a {@link Scene} it can also handle Constraints.
 *
 * @author tecno-master
 * @see com.github.tecnomaster.implementation.VerletSolver
 * @see VerletGrid
 * @see VerletContainer
 * @version 1.0.0
 */
public interface Solver {

    /**
     * Enables/Disables collisions between spheres. This can drastically improve performance but spheres obviously won't collide.
     * @param b If true spheres WILL collide
     */
    void enableCollisions(boolean b);

    /**
     * Sets a VerletGrid to the Solver. By default, the Grid is null. Insert null value to remove the Grid
     * @param grid The VerletGrid to use for the Solver. Can be null
     */
    void setGrid(VerletGrid grid);

    /**
     * Sets the gravity of the solver.
     * @param x X Velocity of the gravity (0 = zero x gravity)
     * @param y Y Velocity of the gravity (0 = zero y gravity)
     */
    void setGravity(double x, double y);

    /**
     * Sets the amount of sub steps. The amount of sub steps decide how many times the simulation is stepped between each step.
     * Will increase the accuracy of the simulation but tank the performance.
     * Default is 0
     * @param subSteps the amount of sub stepping to take between each step.
     */
    void setSubSteps(int subSteps);

    /**
     * Steps the simulation. Every Physic Object will move towards their next position.
     * @param dt the amount of "time" to step forwards
     */
    void step(float dt);

}
