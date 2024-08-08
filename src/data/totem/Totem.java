package data.totem;

import data.airport.listener.FlightDataObserver;
import data.airport.model.FlightData;
import data.airport.states.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Totem implements FlightDataObserver {

    private final ITotemView view;
    private final List<FlightData> flights;
    private final List<String> flightsState;

    public Totem(String name, ITotemView view, State ...flights) {
        this.view = view;
        view.setTotemTitle(name);

        this.flights = new ArrayList<>(5);
        this.flightsState = new ArrayList<>(4);

        Arrays.stream(flights).toList().forEach(flight -> this.flightsState.add(flight.getClass().getSimpleName()));
    }

    @Override
    public void update(FlightData flight) {
        flights.removeIf(f -> f.getFlightNumber().equals(flight.getFlightNumber()));
        if (isInterested(flight)) flights.add(flight);

        view.clearBuffer();

        flights.forEach(flightData -> view.showText(flightData.toString()));
    }

    private boolean isInterested(FlightData flight){
        return flightsState.contains(flight.getState().getClass().getSimpleName());
    }
}
