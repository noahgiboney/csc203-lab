package equality;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

class CourseSection {
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime) {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      CourseSection check = (CourseSection) obj;
      return this.getEnrollment() == check.getEnrollment() && Objects.equals(this.getNumber(), check.getNumber())
              && Objects.equals(this.getPrefix(), check.getPrefix()) && this.getEndTime() ==  check.getEndTime()
              && this.getStartTime().getHour() == check.getStartTime().getHour() && this.getEndTime().getHour() == check.getEndTime().getHour()
              && this.getStartTime().getMinute() == check.getStartTime().getMinute() && this.getEndTime().getMinute() == check.getEndTime().getMinute();
   }

   @Override
   public int hashCode(){
      return Objects.hash(prefix, number, enrollment, startTime, endTime);
   }

   // additional likely methods not defined since they are not needed for testing

   public String getPrefix() {
      return prefix;
   }

   public String getNumber() {
      return number;
   }

   public int getEnrollment() {
      return enrollment;
   }

   public LocalTime getStartTime() {
      return startTime;
   }

   public LocalTime getEndTime() {
      return endTime;
   }
}
