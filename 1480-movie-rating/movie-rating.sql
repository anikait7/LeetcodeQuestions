-- # Write your MySQL query statement below

(
SELECT u.name AS results
FROM Users u
JOIN MovieRating r ON u.user_id = r.user_id
GROUP BY u.user_id, u.name
ORDER BY COUNT(*) DESC, u.name ASC
LIMIT 1
)

UNION ALL

(
SELECT m.title AS results
FROM Movies m
JOIN MovieRating r ON m.movie_id = r.movie_id
Where r.created_at >= '2020-02-01' 
AND r.created_at <='2020-02-29'
GROUP BY m.movie_id, m.title
ORDER BY AVG(r.rating) DESC, m.title ASC
LIMIT 1
);