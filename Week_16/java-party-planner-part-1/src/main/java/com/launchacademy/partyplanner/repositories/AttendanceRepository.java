package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
