UPDATE influenciadores
SET data_assinatura_contrato = data_contrato;

ALTER TABLE influenciadores
DROP COLUMN data_contrato;