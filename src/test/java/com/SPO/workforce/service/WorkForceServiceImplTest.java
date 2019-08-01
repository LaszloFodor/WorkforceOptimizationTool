package com.SPO.workforce.service;


import com.SPO.workforce.entity.Place;
import com.SPO.workforce.exception.CleanerCapacityException;
import com.SPO.workforce.exception.RoomSizeNotAppropriate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorkForceServiceImplTest {

    private Place place;

    private List<Integer> rooms;

    private WorkForceServiceImpl workForceService;

    @Before
    public void setup() {
        workForceService = new WorkForceServiceImpl();
        rooms = new ArrayList<>();
        place = new Place(rooms, 11, 6);
    }

    @Test
    public void testCalculateCleaners_hugeAmountToClean() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(24);
        rooms.add(28);
        assertEquals(2, workForceService.calculateCleaners(place).get(0).getSenior());
        assertEquals(1, workForceService.calculateCleaners(place).get(0).getJunior());
        assertEquals(2, workForceService.calculateCleaners(place).get(1).getSenior());
        assertEquals(1, workForceService.calculateCleaners(place).get(1).getJunior());
    }

    @Test
    public void testCalculateCleaners_smallAmountToClean() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(10);
        assertEquals(1, workForceService.calculateCleaners(place).get(0).getSenior());
        assertEquals(0, workForceService.calculateCleaners(place).get(0).getJunior());
    }

    @Test(expected = RoomSizeNotAppropriate.class)
    public void testCalculateCleaners_roomSizeTooBig() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(101);
        workForceService.calculateCleaners(place);
    }

    @Test(expected = RoomSizeNotAppropriate.class)
    public void testCalculateCleaners_roomSizeIsZero() throws RoomSizeNotAppropriate, CleanerCapacityException {
        workForceService.calculateCleaners(place);
    }

    @Test(expected = CleanerCapacityException.class)
    public void testCalculateCleaners_srJrCleanerCapacityIsZero() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(15);
        place = new Place(rooms, 0, 0);
        workForceService.calculateCleaners(place);
    }

    @Test(expected = CleanerCapacityException.class)
    public void testCalculateCleaners_jrCleanerCapacityIsZero() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(15);
        place = new Place(rooms, 10, 0);
        workForceService.calculateCleaners(place);
    }

    @Test(expected = CleanerCapacityException.class)
    public void testCalculateCleaners_srCleanerCapacityIsZero() throws RoomSizeNotAppropriate, CleanerCapacityException {
        rooms.add(15);
        place = new Place(rooms, 0, 5);
        workForceService.calculateCleaners(place);
    }
}
