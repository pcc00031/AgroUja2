
package daw.agrouja.model.ProductoDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Producto;
import daw.agrouja.model.Usuario;
import daw.agrouja.qualifiers.DAOJpa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@RequestScoped
@DAOJpa
@Transactional
public class ProductosDAOJpa
        implements ProductosDAO, Serializable {

    private static final Logger logger = Logger.getLogger(ProductosDAOJpa.class.getName());

    @PersistenceContext(unitName = "agroPU")
    private EntityManager em;
    private List<Producto> subProductos = new ArrayList<>();

    public ProductosDAOJpa() {

        //subProductos.put(1, new Producto(1, "Azada", "La mejor azada", "AgroUja", "azada.png", "Nuevo", "Maquinaria", "Venta", true, 50.7));
    }

    @Override
    public Producto buscaId(Integer id) {
        Producto p = null;
        try {
            p = em.find(Producto.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }

    @Override
    public List<Producto> buscaTodos() {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p", Producto.class);
            lp = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public List<Producto> buscaTodosSub() {
        return subProductos;
    }

    @Override
    public boolean crea(Producto p) {
        boolean creado = false;
        try {
            // em.createQuery("SELECT u.id, u. FROM Usuario u JOIN c.id p", Usuario.class).setParameter("p", p);
            em.persist(p);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public void borra(Producto p) {
        try {
            p = em.find(Producto.class, p.getId());
            em.remove(p);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public boolean agregarComent(Producto p) {
        boolean add = false;
        try {
            em.merge(p);
            add = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return add;
    }

    @Override
    public boolean edita(Producto p) {
        boolean editado = false;
        try {
            em.merge(p);
            editado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return editado;
    }

    @Override
    public void buscarNombre(String nombre) {
        try {
            Query q = em.createQuery("Select p from Producto p where p.nombre=:nombre", Producto.class).setParameter("nombre", nombre);
            subProductos = q.getResultList();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public List<Producto> buscarMarca(String marca) {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p where p.marca=:marca", Producto.class).setParameter("marca", marca);
            lp = q.getResultList();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public List<Producto> buscarCategoria(String categoria) {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p where p.categoria=:categoria", Producto.class).setParameter("categoria", categoria);
            lp = q.getResultList();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public List<Producto> buscarEstado(String estado) {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p where p.estado=:estado", Producto.class).setParameter("estado", estado);
            lp = q.getResultList();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public Boolean comprobarUsu(Producto p, Usuario u) {
        Boolean coincide = false;
        try {
            Query q = em.createQuery("Select p from Producto p, Usuario u where p.idUsuario=u.id AND :pid=:usuid AND p.id=:pid", Usuario.class);
            q.setParameter("pid", p.getIdUsuario());
            q.setParameter("usuid", u.getId());
            if (q.getSingleResult() != null) {
                coincide = true;
                return coincide;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return coincide;
    }

    @Override
    public Boolean comprobarFav(Producto p, Usuario u) {
        Boolean coincide = false;
        List<Producto> llp;
        try {
            Query q = em.createQuery("Select us.prodsFavs from Producto p, Usuario us where p.idUsuario=:usuid AND p.idUsuario=us.id AND :pid=p.id", Producto.class);
            q.setParameter("pid", p.getIdUsuario());
            q.setParameter("usuid", u.getId());
            llp = q.getResultList();
            if (q.getSingleResult() != null) {
                coincide = true;
                return coincide;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return coincide;
    }

    @Override
    public List<Comentario> buscaComents(Producto p) {
        List<Comentario> lc = new ArrayList<>();
        try {
            Query q = em.createQuery("Select p.comentarios from Producto p where p.id=:pid", Comentario.class);
            q.setParameter("pid", p.getId());
            lc = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }
}