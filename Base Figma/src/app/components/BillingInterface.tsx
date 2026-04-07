import { useState } from 'react';
import { Plus, Trash2, Save, X, Search } from 'lucide-react';

interface InvoiceItem {
  id: string;
  producto: string;
  descripcion: string;
  cantidad: number;
  precioUnitario: number;
  subtotal: number;
}

export function BillingInterface() {
  const [items, setItems] = useState<InvoiceItem[]>([
    {
      id: '1',
      producto: '',
      descripcion: '',
      cantidad: 1,
      precioUnitario: 0,
      subtotal: 0,
    },
  ]);

  const [clienteNombre, setClienteNombre] = useState('');
  const [clienteRFC, setClienteRFC] = useState('');
  const [clienteDireccion, setClienteDireccion] = useState('');

  const addItem = () => {
    const newItem: InvoiceItem = {
      id: Date.now().toString(),
      producto: '',
      descripcion: '',
      cantidad: 1,
      precioUnitario: 0,
      subtotal: 0,
    };
    setItems([...items, newItem]);
  };

  const removeItem = (id: string) => {
    if (items.length > 1) {
      setItems(items.filter(item => item.id !== id));
    }
  };

  const updateItem = (id: string, field: keyof InvoiceItem, value: string | number) => {
    setItems(items.map(item => {
      if (item.id === id) {
        const updatedItem = { ...item, [field]: value };
        if (field === 'cantidad' || field === 'precioUnitario') {
          updatedItem.subtotal = updatedItem.cantidad * updatedItem.precioUnitario;
        }
        return updatedItem;
      }
      return item;
    }));
  };

  const calcularSubtotal = () => {
    return items.reduce((sum, item) => sum + item.subtotal, 0);
  };

  const calcularIVA = () => {
    return calcularSubtotal() * 0.16;
  };

  const calcularTotal = () => {
    return calcularSubtotal() + calcularIVA();
  };

  const handleGuardar = () => {
    alert('Factura guardada exitosamente');
  };

  const handleCancelar = () => {
    if (confirm('¿Deseas cancelar esta factura?')) {
      setItems([{
        id: '1',
        producto: '',
        descripcion: '',
        cantidad: 1,
        precioUnitario: 0,
        subtotal: 0,
      }]);
      setClienteNombre('');
      setClienteRFC('');
      setClienteDireccion('');
    }
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex items-center justify-between">
        <div>
          <h2 className="text-3xl font-semibold text-slate-900">Nueva Factura</h2>
          <p className="text-slate-600 mt-1">Registra una nueva compra o venta</p>
        </div>
        <div className="flex gap-3">
          <button
            onClick={handleCancelar}
            className="flex items-center gap-2 px-4 py-2 border border-slate-300 text-slate-700 rounded-lg hover:bg-slate-50 transition-colors"
          >
            <X size={18} />
            Cancelar
          </button>
          <button
            onClick={handleGuardar}
            className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors"
          >
            <Save size={18} />
            Guardar Factura
          </button>
        </div>
      </div>

      {/* Información del Cliente */}
      <div className="bg-white rounded-xl shadow-sm border border-slate-200 p-6">
        <h3 className="text-lg font-semibold text-slate-900 mb-4">Información del Cliente</h3>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              Nombre del Cliente
            </label>
            <div className="relative">
              <input
                type="text"
                value={clienteNombre}
                onChange={(e) => setClienteNombre(e.target.value)}
                placeholder="Ingresa el nombre"
                className="w-full px-4 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
              />
              <Search className="absolute right-3 top-1/2 transform -translate-y-1/2 text-slate-400" size={18} />
            </div>
          </div>
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              RFC / ID Fiscal
            </label>
            <input
              type="text"
              value={clienteRFC}
              onChange={(e) => setClienteRFC(e.target.value)}
              placeholder="Ingresa el RFC"
              className="w-full px-4 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
            />
          </div>
          <div className="md:col-span-2">
            <label className="block text-sm font-medium text-slate-700 mb-2">
              Dirección
            </label>
            <input
              type="text"
              value={clienteDireccion}
              onChange={(e) => setClienteDireccion(e.target.value)}
              placeholder="Ingresa la dirección"
              className="w-full px-4 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
            />
          </div>
        </div>
      </div>

      {/* Tabla de Productos */}
      <div className="bg-white rounded-xl shadow-sm border border-slate-200 overflow-hidden">
        <div className="p-6 border-b border-slate-200 flex items-center justify-between">
          <h3 className="text-lg font-semibold text-slate-900">Productos / Servicios</h3>
          <button
            onClick={addItem}
            className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors text-sm"
          >
            <Plus size={18} />
            Agregar Item
          </button>
        </div>
        
        <div className="overflow-x-auto">
          <table className="w-full">
            <thead className="bg-slate-50">
              <tr>
                <th className="px-4 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider w-1/4">
                  Producto
                </th>
                <th className="px-4 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider w-1/3">
                  Descripción
                </th>
                <th className="px-4 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider w-24">
                  Cantidad
                </th>
                <th className="px-4 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider w-32">
                  Precio Unitario
                </th>
                <th className="px-4 py-3 text-left text-xs font-medium text-slate-600 uppercase tracking-wider w-32">
                  Subtotal
                </th>
                <th className="px-4 py-3 w-12"></th>
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-slate-200">
              {items.map((item) => (
                <tr key={item.id} className="hover:bg-slate-50">
                  <td className="px-4 py-3">
                    <input
                      type="text"
                      value={item.producto}
                      onChange={(e) => updateItem(item.id, 'producto', e.target.value)}
                      placeholder="Nombre del producto"
                      className="w-full px-3 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-sm"
                    />
                  </td>
                  <td className="px-4 py-3">
                    <input
                      type="text"
                      value={item.descripcion}
                      onChange={(e) => updateItem(item.id, 'descripcion', e.target.value)}
                      placeholder="Descripción"
                      className="w-full px-3 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-sm"
                    />
                  </td>
                  <td className="px-4 py-3">
                    <input
                      type="number"
                      value={item.cantidad}
                      onChange={(e) => updateItem(item.id, 'cantidad', parseFloat(e.target.value) || 0)}
                      min="0"
                      step="1"
                      className="w-full px-3 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-sm"
                    />
                  </td>
                  <td className="px-4 py-3">
                    <div className="relative">
                      <span className="absolute left-3 top-1/2 transform -translate-y-1/2 text-slate-600 text-sm">$</span>
                      <input
                        type="number"
                        value={item.precioUnitario}
                        onChange={(e) => updateItem(item.id, 'precioUnitario', parseFloat(e.target.value) || 0)}
                        min="0"
                        step="0.01"
                        className="w-full pl-7 pr-3 py-2 border border-slate-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-sm"
                      />
                    </div>
                  </td>
                  <td className="px-4 py-3">
                    <span className="text-sm font-medium text-slate-900">
                      ${item.subtotal.toFixed(2)}
                    </span>
                  </td>
                  <td className="px-4 py-3">
                    <button
                      onClick={() => removeItem(item.id)}
                      className="p-2 text-red-600 hover:bg-red-50 rounded-lg transition-colors"
                      disabled={items.length === 1}
                    >
                      <Trash2 size={16} />
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>

      {/* Totales */}
      <div className="flex justify-end">
        <div className="bg-white rounded-xl shadow-sm border border-slate-200 p-6 w-full max-w-md">
          <h3 className="text-lg font-semibold text-slate-900 mb-4">Resumen</h3>
          <div className="space-y-3">
            <div className="flex justify-between text-slate-700">
              <span>Subtotal:</span>
              <span className="font-medium">${calcularSubtotal().toFixed(2)}</span>
            </div>
            <div className="flex justify-between text-slate-700">
              <span>IVA (16%):</span>
              <span className="font-medium">${calcularIVA().toFixed(2)}</span>
            </div>
            <div className="pt-3 border-t border-slate-200 flex justify-between text-slate-900">
              <span className="text-lg font-semibold">Total:</span>
              <span className="text-lg font-semibold">${calcularTotal().toFixed(2)}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
