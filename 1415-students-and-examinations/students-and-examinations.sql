# Write your MySQL query statement below
select s.student_id, s.student_name, sub.subject_name, COUNT(e.subject_name) as attended_exams from Students s Cross Join
Subjects sub Left Join Examinations e on s.student_id = e.student_id  and e.subject_name=sub.subject_name
group by s.student_id, sub.subject_name, s.student_name
order by s.student_id asc, sub.subject_name asc
