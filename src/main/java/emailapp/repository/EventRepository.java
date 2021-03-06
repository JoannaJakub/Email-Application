package emailapp.repository;

import emailapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("from Event e where not(e.end < :from or e.start > :to)")
    public List<Event> findBetween(@Param("from") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                   @Param("to") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime end);

    Event findByStart(LocalDateTime start);
}
