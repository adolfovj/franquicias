package com.adovj.franquicias.repository;

import com.adovj.franquicias.entity.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Transactional
    void deleteByIdAndSucursalId(Integer id, Integer sucursalId);

    @Query("""
        SELECT q FROM Producto q
        WHERE q.sucursal.franquicia.id = :franquiciaId
          AND q.stock = (SELECT MAX(q2.stock) FROM Producto q2
                         WHERE q2.sucursal = q.sucursal)
        ORDER BY q.sucursal.id
        """)
    List<Producto> maxStock(@Param("franquiciaId") Integer franquiciaId);

}
