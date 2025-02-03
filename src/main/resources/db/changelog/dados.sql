


SELECT ts.Tipo, e.estado, COUNT(p.id) AS Quantidade
FROM pessoa p
JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id
JOIN endereco e ON p.endereco_id = e.id
WHERE ts.Tipo = 'A+' -- Substitua 'A+' pelo tipo sanguíneo desejado
GROUP BY ts.Tipo, e.estado;

SELECT ts.Tipo, e.estado, COUNT(p.id) AS Quantidade
FROM pessoa p
JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id
JOIN endereco e ON p.endereco_id = e.id
GROUP BY ts.Tipo, e.estado;

SELECT ts.Tipo, AVG(TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE())) AS MediaIdade
FROM pessoa p
JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id
GROUP BY ts.Tipo;

SELECT ts.Tipo AS TipoReceptor, COUNT(p.id) AS QuantidadeDoadores
FROM pessoa p
JOIN tipo_sanguineo ts ON p.tipo_sanguineo_id = ts.id
JOIN Compatibilidade c ON ts.id = c.TipoReceptor
WHERE p.tipo_sanguineo_id = c.TipoDoador
AND TIMESTAMPDIFF(YEAR, p.data_nascimento, CURDATE()) BETWEEN 16 AND 69
GROUP BY ts.Tipo;