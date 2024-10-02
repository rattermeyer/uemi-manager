CREATE OR REPLACE VIEW tlmt.portfolioitem_assessment_transposed AS
(SELECT DISTINCT radar_id,
                 pia.portfolioitem_id,
                 pi.uuid,
                 pia.portfolioitem_name,
                 1                                                                      AS stars,
                 (SELECT sum(one_star) AS associate
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ASSOCIATE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(one_star) AS professional
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'PROFESSIONAL'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(one_star) AS senior
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SENIOR'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(one_star) AS lead
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'LEAD'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(one_star) AS enterprise
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ENTERPRISE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(one_star) AS sonstige
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SONSTIGE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 coalesce((SELECT sum(one_star) AS all_ratings
                           FROM portfolioitem_assessment pia2
                           WHERE joblevel = 'ALL'
                             AND pia2.portfolioitem_id = pia.portfolioitem_id
                             AND pia2.radar_id = pia.radar_id
                           GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name), 0) AS all_ratings
 FROM portfolioitem_assessment pia
          JOIN portfolioitem pi ON pia.portfolioitem_id = pi.id)
UNION
(SELECT DISTINCT radar_id,
                 pia.portfolioitem_id,
                 pi.uuid,
                 pia.portfolioitem_name,
                 2                                                                      AS stars,
                 (SELECT sum(two_stars) AS associate
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ASSOCIATE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(two_stars) AS professional
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'PROFESSIONAL'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(two_stars) AS senior
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SENIOR'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(two_stars) AS lead
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'LEAD'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(two_stars) AS enterprise
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ENTERPRISE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(two_stars) AS sonstige
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SONSTIGE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 coalesce((SELECT sum(two_stars) AS all_ratings
                           FROM portfolioitem_assessment pia2
                           WHERE joblevel = 'ALL'
                             AND pia2.portfolioitem_id = pia.portfolioitem_id
                             AND pia2.radar_id = pia.radar_id
                           GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name), 0) AS all_ratings
 FROM portfolioitem_assessment pia
          JOIN portfolioitem pi ON pia.portfolioitem_id = pi.id)
UNION
(SELECT DISTINCT radar_id,
                 pia.portfolioitem_id,
                 pi.uuid,
                 pia.portfolioitem_name,
                 3                                                                      AS stars,
                 (SELECT sum(three_stars) AS associate
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ASSOCIATE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(three_stars) AS professional
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'PROFESSIONAL'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(three_stars) AS senior
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SENIOR'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(three_stars) AS lead
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'LEAD'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(three_stars) AS enterprise
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ENTERPRISE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(three_stars) AS sonstige
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SONSTIGE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 coalesce((SELECT sum(three_stars) AS all_ratings
                           FROM portfolioitem_assessment pia2
                           WHERE joblevel = 'ALL'
                             AND pia2.portfolioitem_id = pia.portfolioitem_id
                             AND pia2.radar_id = pia.radar_id
                           GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name), 0) AS all_ratings
 FROM portfolioitem_assessment pia
          JOIN portfolioitem pi ON pia.portfolioitem_id = pi.id)
UNION
(SELECT DISTINCT radar_id,
                 pia.portfolioitem_id,
                 pi.uuid,
                 pia.portfolioitem_name,
                 4                                                                      AS stars,
                 (SELECT sum(four_stars) AS associate
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ASSOCIATE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(four_stars) AS professional
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'PROFESSIONAL'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(four_stars) AS senior
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SENIOR'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(four_stars) AS lead
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'LEAD'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(four_stars) AS enterprise
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'ENTERPRISE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 (SELECT sum(four_stars) AS sonstige
                  FROM portfolioitem_assessment pia2
                  WHERE joblevel = 'SONSTIGE'
                    AND pia2.portfolioitem_id = pia.portfolioitem_id
                    AND pia2.radar_id = pia.radar_id
                  GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name, joblevel),
                 coalesce((SELECT sum(four_stars) AS all_ratings
                           FROM portfolioitem_assessment pia2
                           WHERE joblevel = 'ALL'
                             AND pia2.portfolioitem_id = pia.portfolioitem_id
                             AND pia2.radar_id = pia.radar_id
                           GROUP BY pia2.portfolioitem_id, pia2.portfolioitem_name), 0) AS all_ratings
 FROM portfolioitem_assessment pia
          JOIN portfolioitem pi ON pia.portfolioitem_id = pi.id)
ALTER VIEW portfolioitem_assessment_overview OWNER TO tlmt_admin
