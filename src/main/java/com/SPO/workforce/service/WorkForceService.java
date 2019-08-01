package com.SPO.workforce.service;


import com.SPO.workforce.entity.Cleaners;
import com.SPO.workforce.entity.Place;
import com.SPO.workforce.exception.CleanerCapacityException;
import com.SPO.workforce.exception.RoomSizeNotAppropriate;

import java.util.List;

public interface WorkForceService {

    List<Cleaners> calculateCleaners(Place place) throws RoomSizeNotAppropriate, CleanerCapacityException;

}
